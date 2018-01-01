package min.vm.internal;

/**
 * MinVM OpCodes
 * OpCode is command used by MinVM to tell the VM what to do
 * OpCode Categories:
 * New, Call, Get, Move, Delete, Flow, Calc, Op, Extra
 */

public enum OpCode {
    //New
    //Java Primitives

    //New a byte, save to register(or variable).
    //new-byte [byte]
    //new-byte 'var [byte]
    NEW_BYTE,
    //new-char [character]
    //new-char 'var [character]
    NEW_CHAR,
    //new-long [long]
    //new-long 'var [long]
    NEW_LONG,
    //...
    NEW_INT,
    NEW_SHORT,
    NEW_DOUBLE,
    NEW_FLOAT,
    //new-true (var)
    NEW_BOOL_TRUE,
    //...
    NEW_BOOL_FALSE,

    //Array

    //new-array ('var) [[var names]
    NEW_ARRAY,
    //new-array-range [from num] [to num] ;must be integer
    NEW_ARRAY_RANGE,

    //Objects

    //new ('var) ['class];optional. can be ignored if register is storing target class constructor args...
    NEW_OBJECT,

    //Call

    //Protected call to method
    //pcall ;like call
    PCALL,
    //Call a method of an instance object
    //call [var] [id] [args]
    CALL,
    //Call a static method
    //call-static (class name, if class not present)'classname [class var] [method_id] [args]
    //call-static [args] if register instanceof Method
    CALL_STATIC,
    //Call a method of instance object in register
    //call-x [name] [method_id] [args]
    //or call-x [instance object] [args] if x instanceof Method
    CALL_X,
    //Call a method of Exception in error register
    //call-error [method_id] [args]
    //e.g. call-error printStackTrace
    CALL_ERROR,
    //Call a method using register as first param
    //call-ax ;like call
    CALL_AX,
    //...
    CALL_ARESULT,
    CALL_AERROR,

    //Get

    //Move value of a variable to register
    //get [var]
    GET,
    //gets VM call stack
    //get-stack
    GET_STACK,
    //gets VM Memory
    GET_VARS,
    //get a class with name(Class.forName)
    //get-class [name]
    GET_CLASS,
    //get a method
    //get-method [class] [name]
    GET_METHOD,
    //move value of a class/object field into register
    //get-field [class/object] [id]
    GET_FIELD,
    //gets accessibility of a class/field/method
    //get-accessible? [class name] ('field name)/(method name)
    GET_ACCESSIBLE,

    //moves result register value to register
    //(no args)
    GET_RESULT,
    //...
    GET_ERROR,

    //get-index [var] [idx]
    //get-index [idx] ;if register value can be indexed
    GET_INDEX,

    //Move
    //moves a var
    //move var (to) var
    //move [var] register -> var
    MOVE,
    //move error register to ...
    //move-error [var]
    MOVE_ERROR,
    //...
    MOVE_RESULT,
    //...
    MOVE_FIELD,
    //...
    MOVE_INDEX,
    //...
    MOVE_ACCESSIBLE,

    //Delete
    DELETE,
    DELETE_ERROR,
    DELETE_RESULT,
    DELETE_INDEX,
    //reset VM variables table
    DELETE_ENV,

    //Flow Control

    //throw an exception to host app
    //raise [message]
    //raise 'var
    //raise (error register)
    RAISE,
    //raise an error if register is true
    //raiseif ;like raise
    RAISEIF,

    //end program executing
    //leave
    LEAVE,
    //leave if register == true
    LEAVEIF,

    //jump [(real)line]
    //will be replaced by InstructionSequence index  in run-time
    JUMP,
    JUMPIF,
    JUMPIFNOT,
    JUMPIFERR,

    //returns to location before-jump
    RETURN,
    RETURNIF,
    //before returning, move register to null
    RETURN_VOID,
    RETURN_VOIDIF,

    //sleep [millis]
    SLEEP,

    //implement a Java interface
    //impl [interface] [method_id] [args mapping]: [code chunk]
    /*
    impl android.widget.View.OnClickListener onClick v:
     call-static 'java.lang.System gc
     */
    IMPL,
    //MinVM lambda, is a simple Java Object runs code chunk in same context
    //lambda (optional name):
    /*
    str-new Hello, world!
    move welcome
    lambda:
     call-static 'java.lang.System.out println welcome
    begin
    .use go if you want to start in new thread
     */
    PROC,

    //runs lambda in new thread
    //go (optional name) if x not instanceof Lambda
    GO,
    //...;like ^
    BEGIN,

    //Calc
    //Math
    // + op
    //calc-add var1 var2
    //calc-add var (to x
    //calc-add var1 var2 var3...
    CALC_ADD,
    // - op
    //calc-sub var1 var2
    //calc-sub var(x sub var
    CALC_SUB,
    // * op
    //like add
    CALC_MUL,
    // / op
    //like sub
    CALC_DIV,

    // ^ op
    //calc-pwr (optional var) if x not numeric
    CALC_PWR,
    // % op
    //calc-rem (optional var1) var2
    CALC_REM,
    //negative
    //calc-neg (optional var)
    CALC_NEG,

    //Logical
    CALC_AND,
    CALC_OR,
    //calc-not var
    CALC_NOT,
    CALC_XOR,
    //Binary
    CALC_BAND,
    CALC_BOR,
    CALC_BNOT,
    CALC_BXOR,

    //Other Operations
    //convert utils.
    //like op-convert parsenum [var]
    OP_CONVERT,
    //get array length(maybe in register)
    OP_LEN,
    //is variable(register) null?
    //op-null? var
    //op-null?
    OP_NULL,
    //op-is_a? int var
    //op-in_a? android.widget.EditText
    OP_IS_A,

    // var==var2?
    OP_EQ,
    // ==0?
    OP_EQZ,

    // !=?
    OP_NE,
    // !=0?
    OP_NEZ,

    // <?
    OP_GT,
    // 0<?
    OP_GTZ,

    // >?
    OP_LT,
    OP_LTZ,

    //Extra Struct
    //new a map
    //(like new-int
    MAP_NEW,
    //map-add [name] [var]
    MAP_ADD,
    //map-index [idx] -> x
    MAP_INDEX,
    //map-move map_var [idx] [new-var]
    MAP_MOVE,
    //map-delete map_var [idx]
    MAP_DELETE,
    //has_key?
    MAP_HAS_KEY,
    //has_value?
    MAP_HAS_VAL,
    //find the index of a value in a map
    MAP_LOCATE,
    //get map length
    MAP_LEN,

    //string bind
    STR_NEW,
    STR_INCLUDE,
    STR_LOCATE,
    STR_CAT,
    STR_INSERT,
    STR_INDEX,
    STR_MOVE,
    STR_DELETE,
    STR_TRIM,
    STR_REPLACE,
    STR_START_WITH,
    STR_END_WITH,
    STR_LEN,

    //vector stack op
    VEC_NEW,
    VEC_TOP,
    VEC_PUSH,
    VEC_POP,

    VEC_ADD,
    VEC_INDEX,
    VEC_MOVE,
    VEC_DELETE,
    VEC_INCLUDE,
    VEC_LOCATE,
    VEC_LEN,

    //Other info used by VM execution

    //Used by MinVM Scoping
    //scope
    SCOPE,
    //scope-end
    SCOPE_END;

    static {
        NEW_BOOL_TRUE.special = "new-true";
        NEW_BOOL_FALSE.special = "new-false";
        NEW_OBJECT.special = "new";

        CALL_AX.special = "call-Ax";
        CALL_ARESULT.special = "call-Aresult";
        CALL_AERROR.special = "call-Aerror";

        GET_ACCESSIBLE.special = "get-accessible?";

        OP_NULL.special = "op-null?";
        OP_IS_A.special = "op-is_a?";

        OP_EQ.special = "op-eq?";
        OP_EQZ.special = "op-eqz?";

        OP_NE.special = "op-ne?";
        OP_NEZ.special = "op-nez?";

        OP_GT.special = "op-gt?";
        OP_GTZ.special = "op-gtz?";

        OP_LT.special = "op-lt?";
        OP_LTZ.special = "op-ltz?";

        MAP_HAS_KEY.special = "map-has_key?";
        MAP_HAS_VAL.special = "map-has_val?";

        STR_INCLUDE.special = "str-include?";
        STR_START_WITH.special = "str-start_with?";
        STR_END_WITH.special = "str-end_with?";

        VEC_INCLUDE.special = "vec-include?";
    }

    private String special = null;

    @Override
    public String toString() {
        return this.special == null ? name().toLowerCase().replace("_", "-") : this.special;
    }
}
