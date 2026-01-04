# cfml_parser - CLI tool for parsing cfm/cfc files.
## Project description
cfml_parser is a CLI tool for parsing CFML(.cfm,/cfc) files and generate AST tree in JSON format. It uses Visual Studio Code [Adobe ColdFusion Builder](https://marketplace.visualstudio.com/items?itemName=com-adobe-coldfusion.adobe-cfml-lsp) plugin parser to do the parsing.

## Usage
Example: test.cfm
``` 
<cfset some_var = "some value" />
```
```bash
./cfml_parser test.cfm
```
```json
[{
  "closingToken": {
    "endLine": 1,
    "image": "/>",
    "endColumn": 33,
    "actualEndColumnOffset": 32,
    "specialToken": {
      "endLine": 1,
      "image": " ",
      "endColumn": 31,
      "actualEndColumnOffset": 0,
      "beginColumn": 31,
      "actualStartColumnOffset": 0,
      "kind": 21,
      "beginLine": 1,
      "adjustedBeginColumn": 0,
      "actualLineBeginColumn": 0,
      "class": "Token"
    },
    "beginColumn": 32,
    "actualStartColumnOffset": 31,
    "kind": 4,
    "beginLine": 1,
    "adjustedBeginColumn": 0,
    "actualLineBeginColumn": 32,
    "class": "Token"
  },
  "calledFromScript": false,
  "static": false,
  "tagsWithSecondStartToken": [
    "cfcomponent",
    "cfinterface"
  ],
  "isTagInvocationInScript": false,
  "isFunction": false,
  "isEmpty": false,
  "slot": 0,
  "tagName": "cfset",
  "errorCountAtNode": 0,
  "namedChildren": {},
  "colorizerVisited": false,
  "nodeHasComment": false,
  "children": [{
    "static": false,
    "stmtType": 3,
    "assignmentOpToken": {
      "endLine": 1,
      "image": "=",
      "endColumn": 17,
      "actualEndColumnOffset": 16,
      "specialToken": {
        "endLine": 1,
        "image": " ",
        "endColumn": 16,
        "actualEndColumnOffset": 0,
        "beginColumn": 16,
        "actualStartColumnOffset": 0,
        "kind": 21,
        "beginLine": 1,
        "adjustedBeginColumn": 0,
        "actualLineBeginColumn": 0,
        "class": "Token"
      },
      "beginColumn": 17,
      "actualStartColumnOffset": 16,
      "kind": 136,
      "beginLine": 1,
      "adjustedBeginColumn": 0,
      "actualLineBeginColumn": 17,
      "class": "Token"
    },
    "errorCountAtNode": 0,
    "namedChildren": {
      "lval": {
        "isStatic": false,
        "isStaticAccessor": false,
        "static": false,
        "isSafePreHook": false,
        "codegenVarName": "SOME_VAR",
        "isIIFE": false,
        "type": "class java.lang.Object",
        "errorCountAtNode": 0,
        "namedChildren": {},
        "colorizerVisited": false,
        "nodeHasComment": false,
        "accessorReference": "",
        "isLocalVariable": false,
        "children": [],
        "isLeafReference": true,
        "spreadOperation": false,
        "id": 10002,
        "class": "ASTsimpleVariableReference",
        "spannedNodes": []
      },
      "rval": {
        "static": false,
        "isIIFE": false,
        "type": "class java.lang.String",
        "errorCountAtNode": 0,
        "namedChildren": {},
        "colorizerVisited": false,
        "nodeHasComment": false,
        "children": [],
        "spreadOperation": false,
        "tokens": ["some value"],
        "id": 32,
        "class": "ASTliteral",
        "spannedNodes": []
      }
    },
    "colorizerVisited": false,
    "nodeHasComment": false,
    "elseStatement": false,
    "children": [],
    "isStringLiteralInvocation": false,
    "stmtSubType": 0,
    "id": 3,
    "class": "create_ASTcfscriptStatement",
    "spannedNodes": []
  }],
  "tagCount": 0,
  "runtimeValidation": false,
  "id": 4,
  "extagcToken": {
    "endLine": 1,
    "image": "/>",
    "endColumn": 33,
    "actualEndColumnOffset": 32,
    "specialToken": {
      "endLine": 1,
      "image": " ",
      "endColumn": 31,
      "actualEndColumnOffset": 0,
      "beginColumn": 31,
      "actualStartColumnOffset": 0,
      "kind": 21,
      "beginLine": 1,
      "adjustedBeginColumn": 0,
      "actualLineBeginColumn": 0,
      "class": "Token"
    },
    "beginColumn": 32,
    "actualStartColumnOffset": 31,
    "kind": 4,
    "beginLine": 1,
    "adjustedBeginColumn": 0,
    "actualLineBeginColumn": 32,
    "class": "Token"
  },
  "class": "ASTcfscript",
  "isCfset": true,
  "spannedNodes": []
}]
```
