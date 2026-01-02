package com.adobe.editor.cfml.parser.generated;
import com.adobe.coldfusion.ls.CFMLParserManager;
import com.adobe.editor.cfml.util.BOMUtil;
import com.adobe.ide.coldfusion.dictionary.DictionaryManager;

import org.json.*;

import java.io.*;


public class CFParse {

    private static JSONObject create_StatementNode(StatementNode obj) throws JSONException {
        //assert(obj.getClass() == StatementNode.class);
        if (obj == null) {
            return null;
        }

        JSONObject ret = create_Node(obj);

        if (obj.extagcToken != null) {
            ret.put("extagcToken", create_Token(obj.extagcToken));
        }

        return ret;
    }

    private static JSONObject create_ASToperator(ASToperator obj) throws JSONException {
        JSONObject ret = create_ExprNode(obj);

        ret.put("class", "ASToperator");

        //ret.put("operator", create_Token(obj.getOperator()));

        return ret;
    }

    private static JSONObject create_ASTcftry(ASTcftry obj) throws JSONException {
        JSONObject ret = create_StatementNode(obj);

        ret.put("class", "ASTcftry");

        /*JSONArray catchBlocks = null;
        if (obj.catchBlocks != null) {
            catchBlocks = new JSONArray();
            for (var item : obj.catchBlocks) {
                catchBlocks.put(create_ASTcfcatch((ASTcfcatch) item));
            }
        }
        ret.put("catchBlocks", catchBlocks);

        ret.put("finallyStmt", create_ASTcffinally(obj.finallyStmt));
        ret.put("tryCatchUniqueSuffix", obj.tryCatchUniqueSuffix);
        ret.put("isScript", obj.isScript);*/

        return ret;
    }

    private static JSONObject create_ASTtagAttribute(ASTtagAttribute obj) throws JSONException {
        JSONObject ret = create_Node(obj);

        ret.put("class", "ASTtagAttribute");

        //ret.put("attrName", create_Token(obj.getNameToken()));

        return ret;
    }

    private static JSONObject create_ASTcffunction(ASTcffunction obj) throws JSONException {
        JSONObject ret = create_ASTfunctionDefinition(obj);

        ret.put("class", "ASTcffunction");

        JSONObject attrMap = null;
        if (obj.attrMap != null) {
            attrMap = new JSONObject();
            for (var key : obj.attrMap.keySet()) {
                attrMap.put((String) key, recursiveWalk((Node) obj.attrMap.get(key)));
            }
        }
        ret.put("attrMap", attrMap);

        ret.put("output", obj.output);

        if (obj.accessModifier != null) {
            ret.put("accessModifier", obj.accessModifier);
        }

        if (obj.openBraceToken != null) {
            ret.put("openBraceToken", create_Token(obj.openBraceToken));
        }

        if (obj.closeBraceToken != null) {
            ret.put("closeBraceToken", create_Token(obj.closeBraceToken));
        }

        ret.put("autoGetterSetter", obj.isAutoGetterSetter());

        return ret;
    }

    private static JSONObject create_ASTfunctionDefinition(ASTfunctionDefinition obj) throws JSONException {
        JSONObject ret = create_StatementNode(obj);

        ret.put("class", "ASTfunctionDefinition");

        ret.put("functionName", create_Token(obj.functionName));
        ret.put("parameterDefinition", create_ASTparameterDefinition(obj.parameterDefinition));
        ret.put("calledName", obj.calledName);
        ret.put("closure", obj.closure);
        ret.put("anonymousClosure", obj.anonymousClosure);

        return ret;
    }

    private static JSONObject create_ASTexprlist(ASTexprlist obj) throws JSONException {
        return create_Node(obj);
    }

    private static JSONObject create_ASTreturnStatement(ASTreturnStatement obj) throws JSONException {
        JSONObject ret = create_StatementNode(obj);

        ret.put("class", "ASTreturnStatement");

        //ret.put("containsQE", obj.isContainsQE());

        return ret;
    }

    private static JSONObject create_ASTvariableDefinition(ASTvariableDefinition obj) throws JSONException {

        JSONObject ret = create_SimpleNode(obj);

        ret.put("class", "ASTvariableDefinition");

        ret.put("name", obj.name);
        if (obj.initializer != null)
            ret.put("initializer", create_ExprNode(obj.initializer));
        ret.put("variableNameToken", create_Token(obj.variableNameToken));

        return ret;
    }

    private static JSONObject create_ASTStructInitializer(ASTStructInitializer obj) throws JSONException {
        JSONObject ret = create_ExprNode(obj); // TODO Fix here!

        JSONObject initializers = new JSONObject();
        for (var key : obj.initializers.keySet()) {
            initializers.put((String) key, recursiveWalk((Node) obj.initializers.get(key)));
        }
        ret.put("initializers", initializers);
        ret.put("orderedStruct", obj.orderedStruct);
        ret.put("caseSensitiveStruct", obj.caseSensitiveStruct);

        return ret;
    }

    private static JSONObject create_ASTcfrethrow(ASTcfrethrow obj) throws JSONException {
        JSONObject ret;

        ret = create_TagNode(obj);
        ret.put("class", "ASTcfrethrow");

        return ret;
    }

    private static JSONObject create_SimpleNode(SimpleNode obj) throws JSONException {
        JSONObject ret = create_Node(obj);

        if (obj.getStartToken() != null) {
            ret.put("StartToken", create_Token(obj.getStartToken()));
        }

        if (obj.getEndToken() != null) {
            ret.put("EndTToken", create_Token(obj.getEndToken()));
        }

        //ret.put("TaskPriority", obj.jjtGetChild());
        ret.put("string", obj.toString());

        return ret;
    }

    private static JSONObject create_ASTcfcomment(ASTcfcomment obj) throws JSONException {
        JSONObject ret = create_SimpleNode(obj);

        ret.put("class", "ASTcfcomment");

        ret.put("TaskPriority", obj.getTaskPriority());
        ret.put("getTaskText", obj.getTaskText());

        return ret;
    }

    private static JSONObject create_ASTcfbreak(ASTcfbreak obj) throws JSONException {
        JSONObject ret = create_StatementNode(obj);

        ret.put("class", "ASTcfbreak");

        //ret.put("label", obj.getLabel());

        return ret;
    }

    private static JSONObject create_ASTcfargument(ASTcfargument obj) throws JSONException {
        JSONObject ret = create_TagNode(obj);

        ret.put("class", "ASTcfargument");

        ret.put("paramIndex", obj.paramIndex);
        ret.put("paramName", obj.paramName);

        return ret;
    }

    private static JSONObject create_ASTparameterDefinition(ASTparameterDefinition obj) throws JSONException {

        JSONObject ret = create_SimpleNode(obj);

        ret.put("class", "ASTparameterDefinition");

        JSONArray params = null;
        if (obj.params != null) {
            params = new JSONArray();
            for (var item : obj.params) {
                params.put(item);
            }
        }
        ret.put("params", params);

        JSONArray finalParams = null;
        if (obj.finalParams != null) {
            finalParams = new JSONArray();
            for (var item : obj.finalParams) {
                finalParams.put(recursiveWalk((Node) item));
            }
        }
        ret.put("finalParams", finalParams);

        return ret;
    }

    private static JSONObject create_ASTsimpleVariableReference(ASTsimpleVariableReference obj) throws JSONException {
        JSONObject ret = create_VariableReference(obj);

        ret.put("class", "ASTsimpleVariableReference");

        //private static Hashtable potentialBuiltinScopeNames = new Hashtable();
        ret.put("codegenVarName", obj.getCodegenVariableName());
        ret.put("isSafePreHook", obj.isSafePreHook());

        return ret;
    }

    private static JSONObject create_ASTarrayReference(ASTarrayReference obj) throws JSONException {
        JSONObject ret = create_VariableReference(obj);

        ret.put("class", "ASTarrayReference");

        JSONArray indices = null;
        if (obj.indices != null) {
            indices = new JSONArray();
            for (var item : obj.indices) {
                indices.put(recursiveWalk((Node) item));
            }
        }
        ret.put("indices", indices);

        if (obj.getRvalIndex() != null)
            ret.put("rvalIndex", obj.getRvalIndex().toString());

        return ret;
    }

    private static JSONObject create_TagNode(TagNode obj) throws JSONException {
        if (obj == null) {
            return null;
        }

        JSONObject ret = create_StatementNode(obj);

        if (obj.tagsWithSecondStartToken != null)
        {
            ret.put("tagsWithSecondStartToken", obj.tagsWithSecondStartToken);
        }

        if (obj.attrList != null)
            ret.put("attrList", create_ASTexprlist(obj.attrList));

        JSONObject attrMap = null;
        if (obj.attrMap != null) {
            attrMap = new JSONObject();
            for (var key : obj.attrMap.keySet()) {
                if (obj.attrMap.get(key) instanceof Node child) {
                    attrMap.put((String) key, recursiveWalk(child));
                }
            }
        }
        ret.put("attrMap", attrMap);

        ret.put("tagName", obj.tagName);
        ret.put("tagVar", obj.tagVar);
        ret.put("runtimeValidation", obj.runtimeValidation);
        ret.put("calledFromScript", obj.calledFromScript);
        ret.put("switchAttrList", obj.switchAttrList);
        ret.put("switchAttrName", obj.switchAttrName);

        if (obj.startTagEndToken != null) {
            ret.put("startTagEndToken", create_Token(obj.startTagEndToken));
        }

        ret.put("tagCount", obj.tagCount);
        ret.put("slot", obj.slot);
        ret.put("isTagInvocationInScript", obj.isTagInvocationInScript);
        ret.put("tagInvocationName", obj.tagInvocationName);
        ret.put("isFunction", obj.isFunction);
        ret.put("isEmpty", obj.isEmpty());

        return ret;
    }

    private static JSONObject create_ASTcfswitch(ASTcfswitch obj) throws JSONException {
        JSONObject ret = create_TagNode(obj);

        ret.put("class", "ASTcfswitch");

        ret.put("isCFSWITCH", obj.isCFSWITCH);
        ret.put("lookupTableName", obj.lookupTableName);
        ret.put("emittedDefault", obj.emittedDefault);

        return ret;
    }

    private static JSONObject create_ASTcfcase(ASTcfcase obj) throws JSONException {
        JSONObject ret = create_TagNode(obj);

        ret.put("class", "ASTcfcase");

        ret.put("caseSpec", obj.getCaseSpec());
        ret.put("isCfcase", obj.isCfcase);

        return ret;
    }

    private static JSONObject create_ASTcfloop(ASTcfloop obj) throws JSONException {
        JSONObject ret = create_TagNode(obj);

        ret.put("class", "ASTcfloop");

        //ret.put("label", obj.getLabel());

        return ret;
    }

    private static JSONObject create_ASTruntimeCall(ASTruntimeCall obj) throws JSONException {
        JSONObject ret = create_VariableReference(obj);

        ret.put("class", "ASTruntimeCall");

        ret.put("isSafePreHook", obj.isSafePreHook());
        ret.put("isSafePostHook", obj.isSafePostHook());
        if (obj.getNewArgumentCfc() != null)
            ret.put("newArgumentCfc", obj.getNewArgumentCfc());
        //if (obj.arguments != null)
        //    ret.put("arguments", create_ASTfuncparams(obj.arguments));
        ret.put("isSimpleReference", obj.hasSimpleReference());
        ret.put("newOperator", obj.isNew());
        // newArgumentCfcToken
        // dynamicCFCNameExpression
        if (obj.getFuncName() != null)
            ret.put("funcName", create_ExprNode(obj.getFuncName()));
        ret.put("isAssociativeArrayNotation", obj.isAssociativeArrayNotation());
        if (obj.parameterShadow != null) {
            JSONArray parameterShadow = new JSONArray();
            for (var item : obj.parameterShadow) {
                parameterShadow.put(item);
            }
            ret.put("parameterShadow", parameterShadow);
        }
        ret.put("nameToken", create_Token(obj.getNameToken()));

        return ret;
    }

    private static JSONObject create_ASTpcdata(ASTpcdata obj) throws JSONException {
        assert (obj.getClass() == ASTpcdata.class);

        JSONObject ret = create_StatementNode(obj);

        ret.put("class", "ASTpcdata");

        ret.put("buffer", obj.buffer);

        if ((obj.overflowData != null) && (!obj.overflowData.isEmpty())) {
            JSONArray overflowData = new JSONArray();

            for (int c = 0; c < obj.overflowData.size(); c++)
                overflowData.put(obj.overflowData.elementAt(c));

            ret.put("overflowData", overflowData);
        }

        return ret;
    }

    private static JSONObject create_ASTcfscript(ASTcfscript obj) throws JSONException {
        assert (obj.getClass() == ASTcfscript.class);

        JSONObject ret = create_TagNode(obj);

        ret.put("class", "ASTcfscript");

        ret.put("isCfset", obj.isCfset());

        return ret;
    }

    private static JSONObject create_ASTcftag(ASTcftag obj) throws JSONException {
        assert (obj.getClass() == ASTcftag.class);

        JSONObject ret = create_TagNode(obj);

        ret.put("class", "ASTcftag");

        //ret.put("calledName", obj.getCalledName());

        return ret;
    }

    private static JSONObject create_VariableReference(VariableReference obj) throws JSONException {

        JSONObject ret = create_ExprNode(obj);

        ret.put("class", "VariableReference");

        ret.put("isLeafReference", obj.isLeafReference);
        if (obj.getStem() != null)
            ret.put("stem", create_VariableReference(obj.getStem()));
        ret.put("isStatic", obj.isStatic());
        ret.put("isStaticAccessor", obj.isStaticAccessor());
        ret.put("accessorReference", obj.getAccessorReference());
        if (obj.getNewKeywordToken() != null)
            ret.put("newKeywordToken", create_Token(obj.getNewKeywordToken()));
        ret.put("isLocalVariable", obj.isLocalVariable());

        return ret;
    }

    private static JSONObject create_ASTstructureReference(ASTstructureReference obj) throws JSONException {
        //assert(obj.getClass() == ASTstructureReference.class);

        JSONObject ret = create_VariableReference(obj);

        ret.put("class", "ASTstructureReference");

        if (obj.getStructureKeys() != null) {
            JSONArray keys = new JSONArray();
            for (var item : obj.getStructureKeys()) {
                keys.put(item);
            }
            ret.put("keys", keys);
        }
        ret.put("isSafePreHook", obj.isSafePreHook());
        ret.put("isSafePostHook", obj.isSafePostHook());
        ret.put("isLHS", obj.isLHS);

        return ret;
    }

    /*private static JSONObject create_ASTevalcfoutput(ASTevalcfoutput obj) throws JSONException {
        assert (obj.getClass() == ASTevalcfoutput.class);

        return create_SimpleNode(obj);
    }*/

    private static JSONObject create_Token(Token obj) throws JSONException {
        JSONObject ret = new JSONObject();

        if (obj == null)
            return null;

        ret.put("kind", obj.kind);
        ret.put("beginLine", obj.getBeginLine());
        ret.put("beginColumn", obj.getBeginColumn());
        ret.put("endLine", obj.getEndLine());
        ret.put("endColumn", obj.getEndColumn());
        ret.put("image", obj.image);
        ret.put("specialToken", create_Token(obj.specialToken));

        return ret;
    }

    private static JSONObject create_ASTcfscriptStatement(ASTcfscriptStatement obj) throws JSONException {
        //assert(obj.getClass() == ASTcfscriptStatement.class);

        JSONObject ret = create_StatementNode(obj);

        ret.put("class", "ASTstructureReference");

        ret.put("stmtType", obj.stmtType);
        ret.put("assignmentOpToken", create_Token(obj.assignmentOpToken));
        ret.put("stmtSubType", obj.stmtSubType);
        ret.put("elseStatement", obj.elseStatement);
        ret.put("elseToken", create_Token(obj.elseToken));
        ret.put("leftParenToken", create_Token(obj.leftParenToken));
        ret.put("rightParenToken", create_Token(obj.rightParenToken));
        ret.put("label", obj.getLabel());
        ret.put("isStringLiteralInvocation", obj.isStringLiteralInvocation());

        return ret;
    }

    private static JSONObject create_Node(Node obj) throws JSONException {

        var ret = new JSONObject();

        if (obj == null)
            return null;

        if (obj.jjtGetNumChildren() > 0) {
            var children = new JSONArray();
            for (int c = 0; c < obj.jjtGetNumChildren(); c++) {
                var child = obj.jjtGetChild(c);
                children.put(recursiveWalk(child));
            }
            ret.put("children", children);
        }

        ret.put("static", obj.isStatic());

        return ret;
    }

    private static JSONObject create_ExprNode(ExprNode obj) throws JSONException {
        //assert(obj.getClass() == ExprNode.class);
        var ret = create_Node(obj);

        ret.put("class", "ExprNode");

        if (obj.getType() != null)
            ret.put("type", obj.getType().toString());
        ret.put("isIIFE", obj.isIIFE());
        // lBracketToken
        // rBracketToken
        ret.put("exprInitializerNode", create_Node(obj.getExprInitializer()));
        ret.put("spreadOperation", obj.isSpreadOperationType());

        return ret;
    }

    private static JSONObject create_ASTliteral(ASTliteral obj) throws JSONException {

        var ret = create_ExprNode(obj);

        ret.put("class", "ASTliteral");

        ret.put("image", obj.image);

        var tokens = new JSONArray();
        for (int c = 0; c < obj.tokens.size(); c++) {
            var token = obj.tokens.get(c);

            if (token.getClass() == String.class) {
                tokens.put(token.toString());
            } else if (token.getClass() == Integer.class) {
                tokens.put(token.toString());
            } else {
                System.out.println("Unsupported type: " + token);
                System.exit(1);
            }
        }
        ret.put("tokens", tokens);

        return ret;
    }

    private static  JSONObject create_ASTevalcfoutput(ASTevalcfoutput obj)
    {
        var ret = create_SimpleNode(obj);

        ret.put("class", "ASTevalcfoutput");

        return ret;
    }


    private static JSONObject recursiveWalk(com.adobe.editor.cfml.parser.generated.Node node) throws JSONException {
        JSONObject ret;

        switch (node) {
            case ASTcfscript child                -> ret = create_ASTcfscript(child);
            case ASTcfbreak child                 -> ret = create_ASTcfbreak(child);
            case ASTreturnStatement child         -> ret = create_ASTreturnStatement(child);
            case ASTcfloop child                  -> ret = create_ASTcfloop(child);
            case ASTcftag child                   -> ret = create_ASTcftag(child);
            case ASTpcdata child                  -> ret = create_ASTpcdata(child);
            case ASTstructureReference child      -> ret = create_ASTstructureReference(child);
            case ASTcfscriptStatement child       -> ret = create_ASTcfscriptStatement(child);
            case ASTliteral child                 -> ret = create_ASTliteral(child);
            case ASTevalcfoutput child            -> ret = create_ASTevalcfoutput(child);
            case ASToperator child                -> ret = create_ASToperator(child);
            case ASTruntimeCall child             -> ret = create_ASTruntimeCall(child);
            case ASTcfswitch child                -> ret = create_ASTcfswitch(child);
            case ASTcfcase child                  -> ret = create_ASTcfcase(child);
            case ASTsimpleVariableReference child -> ret = create_ASTsimpleVariableReference(child);
            case ASTarrayReference child          -> ret = create_ASTarrayReference(child);
            case ASTcftry child                   -> ret = create_ASTcftry(child);
            case ASTtagAttribute child            -> ret = create_ASTtagAttribute(child);
            case ASTcffunction child              -> ret = create_ASTcffunction(child);
            case ASTparameterDefinition child     -> ret = create_ASTparameterDefinition(child);
            case ASTcfargument child              -> ret = create_ASTcfargument(child);
            case ASTvariableDefinition child      -> ret = create_ASTvariableDefinition(child);
            case ASTStructInitializer child       -> ret = create_ASTStructInitializer(child);
            case ASTcfrethrow child               -> ret = create_ASTcfrethrow(child);
            case ASTcfcomment child               -> ret = create_ASTcfcomment(child);
            case null, default -> {
                ret = new JSONObject();
                ret.put("class", "Unknown");
                if (node != null) {
                    ret.put("obj", node.toString());
                }

                System.out.println("Unknown class: " + node);
                System.exit(1);
            }
        }

        int cnt = node.jjtGetNumChildren();
        if (cnt > 0) {
            JSONArray children = new JSONArray();
            for (int c = 0; c < cnt; c++) {
                children.put(recursiveWalk(node.jjtGetChild(c)));
            }

            ret.put("children", children);
        }

        return ret;
    }

    static void parseFile(String pathName) {

        if ((!pathName.toLowerCase().endsWith(".cfm")) && (!pathName.toLowerCase().endsWith(".cfc")))
            return;

        try {

            InputStream inStream = new FileInputStream(pathName);
            Reader reader = BOMUtil.createReader(inStream);
            ASCII_CharStream charStream = new ASCII_CharStream(reader);
            CFMLParser parser = CFMLParserManager.INSTANCE.getParser(charStream);
            parser.init();
            ASTstart start = parser.start();

            int cnt = start.jjtGetNumChildren();

            JSONArray root = new JSONArray();

            for (int c = 0; c < cnt; c++) {
                root.put(recursiveWalk(start.jjtGetChild(c)));
            }

            String json = root.toString(2);

            if (System.getenv("CFML2JSON") != null) {
                String jsonPathName = pathName + ".json";
                try (FileWriter myWriter = new FileWriter(jsonPathName)) {
                    myWriter.write(json);
                }
            }

            System.out.println(json);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static public void parseFileOrDir(String pathName) {
        DictionaryManager.initDictionaries();

        File isDir = new File(pathName);

        if (isDir.isDirectory()) {
            var files = isDir.listFiles();
            if (files != null) {
                for (var file : files) {
                    var filePathName = file.getAbsolutePath();
                    if (file.isDirectory()) {
                        parseFileOrDir(filePathName);
                    } else if (file.isFile()) {
                        parseFile(filePathName);
                    }
                }
            }
        }

        parseFile(pathName);
    }
}
