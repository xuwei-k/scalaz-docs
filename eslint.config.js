"use strict";

// based on eslint-config-eslint
// https://github.com/eslint/eslint/blob/master/packages/eslint-config-eslint/default.yml
const js = require("@eslint/js");
const globals = require("globals");

module.exports = [
  js.configs.recommended,
  {
    languageOptions: {
      globals: {
        ...globals.node,
        ...globals.es2015,
        ...globals.mocha,
      },
      parserOptions: {
        ecmaVersion: 2015,
        sourceType: "module",
      },
    },
    rules: {
      "no-invalid-this": 0,

      // ES6 RULES
      // require let or const instead of var
      "no-var": 2,
      // require method and property shorthand syntax for object literals
      "object-shorthand": 2,
      // suggest using arrow functions as callbacks
      "prefer-arrow-callback": 1,
      // suggest using of const declaration for variables that are never modified after declared
      "prefer-const": 0,
      // suggest using the spread operator instead of .apply()
      "prefer-spread": 2,
      // suggest using template literals instead of strings concatenation
      "prefer-template": 1,
      // disallow generator functions that do not have yield
      "require-yield": 2,
    },
  },
];
