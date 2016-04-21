#!/bin/bash
set -e

openssl aes-256-cbc -k "$REVIEW_KEY" -in review_key.enc -d -a -out review.key
cp review.key ~/.ssh/
chmod 600 ~/.ssh/review.key
echo -e "Host github.com\n\tStrictHostKeyChecking no\nIdentityFile ~/.ssh/review.key\n" > ~/.ssh/config
git clone git@github.com:xuwei-k/scalaz-docs-pull-req.git
cd scalaz-docs-pull-req
rm -rf ./${TRAVIS_BRANCH}
mkdir ${TRAVIS_BRANCH}
cp -r ../../_book/* ./${TRAVIS_BRANCH}/
git add .
git commit -a -m "auto commit on travis $TRAVIS_JOB_NUMBER $TRAVIS_COMMIT $TRAVIS_BRANCH"
git push origin gh-pages:gh-pages
