#!/bin/bash
set -e

echo -e "Host github.com\n\tStrictHostKeyChecking no\nIdentityFile ~/.ssh/deploy.key\n" >> ~/.ssh/config
openssl aes-256-cbc -k "$SERVER_KEY" -in .travis/deploy_key.enc -d -a -out deploy.key
cp deploy.key ~/.ssh/
chmod 600 ~/.ssh/deploy.key
git config --global user.email "6b656e6a69@gmail.com"
git config --global user.name "xuwei-k"
mv gitbook/_book ../
mv gitbook/book.epub ../_book/scalaz-docs.epub
git fetch origin gh-pages:gh-pages
git clean -fdx
git checkout gh-pages
rm -rf ./*
cp -r ../_book/* ./
git add .
git commit -a -m "auto commit on travis $TRAVIS_JOB_NUMBER $TRAVIS_COMMIT"
tree ./
if [[ "${TRAVIS_BRANCH}" == "master" && "${TRAVIS_PULL_REQUEST}" == "false" ]];
then git push git@github.com:xuwei-k/scalaz-docs.git gh-pages:gh-pages ; fi

cd ..

if [[ "${TRAVIS_BRANCH}" == "master" && "${TRAVIS_PULL_REQUEST}" == "false" ]]; then
  git checkout -qf $TRAVIS_COMMIT
  openssl aes-256-cbc -k "$PDF_KEY" -in travis_deploy_pdf_key.enc -d -a -out pdf.key
  cp pdf.key ~/.ssh/
  chmod 600 ~/.ssh/pdf.key
  echo -e "Host github.com\n\tStrictHostKeyChecking no\nIdentityFile ~/.ssh/pdf.key\n" > ~/.ssh/config
  git clone git@github.com:xuwei-k/scalaz-docs-pdf.git
  cd scalaz-docs-pdf
  git submodule update --init
  cd scalaz-docs
  git pull origin master
  cd ..
  git add scalaz-docs
  git commit -a -m "auto commit on travis $TRAVIS_JOB_NUMBER $TRAVIS_COMMIT"
  git push origin master
fi
