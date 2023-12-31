/*
 * Copyright LWJGL. All rights reserved.
 * License terms: https://www.lwjgl.org/license
 */
package opengl.templates

import org.lwjgl.generator.*
import opengl.*
import opengl.BufferType.*

val GL41C = "GL41C".nativeClassGL("GL41C") {
    extends = GL40C
    documentation =
        """
        The OpenGL functionality up to version 4.1. Includes only Core Profile symbols.

        OpenGL 4.1 implementations support revision 4.10 of the OpenGL Shading Language.

        Extensions promoted to core in this release:
        ${ul(
            registryLinkTo("ARB", "ES2_compatibility"),
            registryLinkTo("ARB", "get_program_binary"),
            registryLinkTo("ARB", "separate_shader_objects"),
            registryLinkTo("ARB", "shader_precision"),
            registryLinkTo("ARB", "vertex_attrib_64bit"),
            registryLinkTo("ARB", "viewport_array")
        )}
        """


    // ARB_ES2_compatibility

    IntConstant(
        "Accepted by the {@code value} parameter of GetBooleanv, GetIntegerv, GetInteger64v, GetFloatv, and GetDoublev.",

        "SHADER_COMPILER"..0x8DFA,
        "SHADER_BINARY_FORMATS"..0x8DF8,
        "NUM_SHADER_BINARY_FORMATS"..0x8DF9,
        "MAX_VERTEX_UNIFORM_VECTORS"..0x8DFB,
        "MAX_VARYING_VECTORS"..0x8DFC,
        "MAX_FRAGMENT_UNIFORM_VECTORS"..0x8DFD,
        "IMPLEMENTATION_COLOR_READ_TYPE"..0x8B9A,
        "IMPLEMENTATION_COLOR_READ_FORMAT"..0x8B9B
    )

    IntConstant(
        "Accepted by the {@code type} parameter of VertexAttribPointer.",

        "FIXED"..0x140C
    )

    IntConstant(
        "Accepted by the {@code precisiontype} parameter of GetShaderPrecisionFormat.",

        "LOW_FLOAT"..0x8DF0,
        "MEDIUM_FLOAT"..0x8DF1,
        "HIGH_FLOAT"..0x8DF2,
        "LOW_INT"..0x8DF3,
        "MEDIUM_INT"..0x8DF4,
        "HIGH_INT"..0x8DF5
    )

    IntConstant(
        "Accepted by the {@code format} parameter of most commands taking sized internal formats.",

        "RGB565"..0x8D62
    )

    void(
        "ReleaseShaderCompiler",
        "Releases resources allocated by the shader compiler. This is a hint from the application, and does not prevent later use of the shader compiler."
    )

    void(
        "ShaderBinary",
        "Loads pre-compiled shader binaries.",

        AutoSize("shaders")..GLsizei("count", "the number of shader object handles contained in {@code shaders}"),
        GLuint.const.p("shaders", "an array of shader handles into which to load pre-compiled shader binaries"),
        GLenum("binaryformat", "the format of the shader binaries contained in {@code binary}"),
        void.const.p("binary", "an array of bytes containing pre-compiled binary shader code"),
        AutoSize("binary")..GLsizei("length", "the length of the array whose address is given in binary")
    )

    void(
        "GetShaderPrecisionFormat",
        "Retrieves the range and precision for numeric formats supported by the shader compiler.",

        GLenum("shadertype", "the type of shader whose precision to query", "#VERTEX_SHADER #FRAGMENT_SHADER"),
        GLenum("precisiontype", "the numeric format whose precision and range to query"),
        Check(2)..GLint.p("range", "the address of array of two integers into which encodings of the implementation's numeric range are returned"),
        Check(1)..ReturnParam..GLint.p("precision", "the address of an integer into which the numeric precision of the implementation is written")
    )

    void(
        "DepthRangef",
        "Specifies mapping of depth values from normalized device coordinates to window coordinates",

        GLfloat("zNear", "the mapping of the near clipping plane to window coordinates. The initial value is 0.0f."),
        GLfloat("zFar", "the mapping of the far clipping plane to window coordinates. The initial value is 1.0f.")
    )

    void(
        "ClearDepthf",
        "Specifies the clear value for the depth buffer",

        GLfloat("depth", "the depth value used when the depth buffer is cleared. The initial value is 1.0f.")
    )

    // ARB_get_program_binary

    IntConstant(
        "Accepted by the {@code pname} parameter of ProgramParameteri and GetProgramiv.",

        "PROGRAM_BINARY_RETRIEVABLE_HINT"..0x8257
    )

    IntConstant(
        "Accepted by the {@code pname} parameter of GetProgramiv.",

        "PROGRAM_BINARY_LENGTH"..0x8741
    )

    IntConstant(
        "Accepted by the {@code pname} parameter of GetBooleanv, GetIntegerv, GetInteger64v, GetFloatv and GetDoublev.",

        "NUM_PROGRAM_BINARY_FORMATS"..0x87FE,
        "PROGRAM_BINARY_FORMATS"..0x87FF
    )

    void(
        "GetProgramBinary",
        "Returns a binary representation of a program object's compiled and linked executable source.",

        GLuint("program", "the name of a program object whose binary representation to retrieve"),
        AutoSize("binary")..GLsizei("bufSize", "the size of the buffer whose address is given by {@code binary}"),
        Check(1)..nullable..GLsizei.p("length", "the address of a variable to receive the number of bytes written into {@code binary}"),
        Check(1)..GLenum.p("binaryFormat", "a variable to receive a token indicating the format of the binary data returned by the GL"),
        void.p(
            "binary",
            "an array into which the GL will return {@code program}'s binary representation"
        )
    )

    void(
        "ProgramBinary",
        "Loads a program object with a program binary.",

        GLuint("program", "the name of a program object into which to load a program binary"),
        GLenum("binaryFormat", "the format of the binary data in binary"),
        void.const.p("binary", "an array containing the binary to be loaded into {@code program}"),
        AutoSize("binary")..GLsizei("length", "the number of bytes contained in {@code binary}")
    )

    void(
        "ProgramParameteri",
        "Specifies the integer value of a program object parameter.",

        GLuint("program", "the name of a program object whose parameter to modify"),
        GLenum("pname", "the name of the parameter to modify", "#PROGRAM_BINARY_RETRIEVABLE_HINT #PROGRAM_SEPARABLE"),
        GLint("value", "the new value of the parameter specified by {@code pname} for {@code program}")
    )

    // ARB_separate_shader_objects

    IntConstant(
        "Accepted by {@code stages} parameter to UseProgramStages.",

        "VERTEX_SHADER_BIT"..0x00000001,
        "FRAGMENT_SHADER_BIT"..0x00000002,
        "GEOMETRY_SHADER_BIT"..0x00000004,
        "TESS_CONTROL_SHADER_BIT"..0x00000008,
        "TESS_EVALUATION_SHADER_BIT"..0x00000010,
        "ALL_SHADER_BITS"..0xFFFFFFFF.i
    )

    IntConstant(
        "Accepted by the {@code pname} parameter of ProgramParameteri and GetProgramiv.",

        "PROGRAM_SEPARABLE"..0x8258
    )

    IntConstant(
        "Accepted by {@code type} parameter to GetProgramPipelineiv.",

        "ACTIVE_PROGRAM"..0x8259
    )

    IntConstant(
        "Accepted by the {@code pname} parameter of GetBooleanv, GetIntegerv, GetInteger64v, GetFloatv, and GetDoublev.",

        "PROGRAM_PIPELINE_BINDING"..0x825A
    )

    void(
        "UseProgramStages",
        "Binds stages of a program object to a program pipeline.",

        GLuint("pipeline", "the program pipeline object to which to bind stages from {@code program}"),
        GLbitfield("stages", "a set of program stages to bind to the program pipeline object"),
        GLuint("program", "the program object containing the shader executables to use in {@code pipeline}")
    )

    void(
        "ActiveShaderProgram",
        "Sets the active program object for a program pipeline object.",

        GLuint("pipeline", "the program pipeline object to set the active program object for"),
        GLuint("program", "the program object to set as the active program pipeline object {@code pipeline}")
    )

    GLuint(
        "CreateShaderProgramv",
        """
        Creates a stand-alone program from an array of null-terminated source code strings.

        {@code glCreateShaderProgram} is equivalent (assuming no errors are generated) to:
        ${codeBlock("""
const GLuint shader = glCreateShader(type);
if (shader) {
    glShaderSource(shader, count, strings, NULL);
    glCompileShader(shader);
    const GLuint program = glCreateProgram();
    if (program) {
        GLint compiled = GL_FALSE;
        glGetShaderiv(shader, GL_COMPILE_STATUS, &compiled);
        glProgramParameteri(program, GL_PROGRAM_SEPARABLE, GL_TRUE);
        if (compiled) {
            glAttachShader(program, shader);
            glLinkProgram(program);
            glDetachShader(program, shader);
        }
        // append-shader-info-log-to-program-info-log
    }
    glDeleteShader(shader);
    return program;
} else {
    return 0;
}
        """)}
        The program object created by glCreateShaderProgram has its GL_PROGRAM_SEPARABLE status set to GL_TRUE.
        """,

        GLenum("type", "the type of shader to create"),
        AutoSize("strings")..GLsizei("count", "the number of source code strings in the array {@code strings}"),
        PointerArray(GLcharUTF8.p, "string")..GLcharUTF8.const.p.const.p(
            "strings",
            "an array of pointers to source code strings from which to create the program object"
        )
    )

    void(
        "BindProgramPipeline",
        "Binds a program pipeline to the current context.",

        GLuint("pipeline", "the name of the pipeline object to bind to the context")
    )

    void(
        "DeleteProgramPipelines",
        "Deletes program pipeline objects.",

        AutoSize("pipelines")..GLsizei("n", "the number of program pipeline objects to delete"),
        SingleValue("pipeline")..GLuint.const.p("pipelines", "an array of names of program pipeline objects to delete")
    )

    void(
        "GenProgramPipelines",
        "Reserves program pipeline object names.",

        AutoSize("pipelines")..GLsizei("n", "the number of program pipeline object names to reserve"),
        ReturnParam..GLuint.p("pipelines", "an array of into which the reserved names will be written")
    )

    GLboolean(
        "IsProgramPipeline",
        "Determines if a name corresponds to a program pipeline object.",

        GLuint("pipeline", "a value that may be the name of a program pipeline object")
    )

    void(
        "GetProgramPipelineiv",
        "Retrieves properties of a program pipeline object.",

        GLuint("pipeline", "the name of a program pipeline object whose parameter retrieve"),
        GLenum(
            "pname",
            "the name of the parameter to retrieve",
            "#ACTIVE_PROGRAM #INFO_LOG_LENGTH $SHADER_TYPES"
        ),
        Check(1)..ReturnParam..GLint.p("params", "a variable into which will be written the value or values of {@code pname} for {@code pipeline}")
    )

    // ProgramUniform JavaDoc
    val uniProgram = "the handle of the program containing the uniform variable to be modified"
    val uniLocation = "the location of the uniform variable to be modified"
    val uniX = "the uniform x value"
    val uniY = "the uniform y value"
    val uniZ = "the uniform z value"
    val uniW = "the uniform w value"

    val uniArrayCount = "the number of elements that are to be modified. This should be 1 if the targeted uniform variable is not an array, and 1 or more if it is an array."
    val uniArrayValue = "an array of {@code count} values that will be used to update the specified uniform variable"

    val uniMatrixCount = "the number of matrices that are to be modified. This should be 1 if the targeted uniform variable is not an array of matrices, and 1 or more if it is an array of matrices."
    val uniMatrixTranspose = "whether to transpose the matrix as the values are loaded into the uniform variable"
    val uniMatrixValue = "an array of {@code count} values that will be used to update the specified uniform matrix variable"

    void(
        "ProgramUniform1i",
        "Specifies the value of an int uniform variable for a specified program object.",

        GLuint("program", uniProgram),
        GLint("location", uniLocation),
        GLint("x", uniX)
    )

    void(
        "ProgramUniform2i",
        "Specifies the value of an ivec2 uniform variable for a specified program object.",

        GLuint("program", uniProgram),
        GLint("location", uniLocation),
        GLint("x", uniX),
        GLint("y", uniY)
    )

    void(
        "ProgramUniform3i",
        "Specifies the value of an ivec3 uniform variable for a specified program object.",

        GLuint("program", uniProgram),
        GLint("location", uniLocation),
        GLint("x", uniX),
        GLint("y", uniY),
        GLint("z", uniZ)
    )

    void(
        "ProgramUniform4i",
        "Specifies the value of an ivec4 uniform variable for a specified program object.",

        GLuint("program", uniProgram),
        GLint("location", uniLocation),
        GLint("x", uniX),
        GLint("y", uniY),
        GLint("z", uniZ),
        GLint("w", uniW)
    )

    void(
        "ProgramUniform1ui",
        "Specifies the value of a uint uniform variable for a specified program object.",

        GLuint("program", uniProgram),
        GLint("location", uniLocation),
        GLuint("x", uniX)
    )

    void(
        "ProgramUniform2ui",
        "Specifies the value of a uvec2 uniform variable for a specified program object.",

        GLuint("program", uniProgram),
        GLint("location", uniLocation),
        GLuint("x", uniX),
        GLuint("y", uniY)
    )

    void(
        "ProgramUniform3ui",
        "Specifies the value of a uvec3 uniform variable for a specified program object.",

        GLuint("program", uniProgram),
        GLint("location", uniLocation),
        GLuint("x", uniX),
        GLuint("y", uniY),
        GLuint("z", uniZ)
    )

    void(
        "ProgramUniform4ui",
        "Specifies the value of a uvec4 uniform variable for a specified program object.",

        GLuint("program", uniProgram),
        GLint("location", uniLocation),
        GLuint("x", uniX),
        GLuint("y", uniY),
        GLuint("z", uniZ),
        GLuint("w", uniW)
    )

    void(
        "ProgramUniform1f",
        "Specifies the value of a float uniform variable for a specified program object.",

        GLuint("program", uniProgram),
        GLint("location", uniLocation),
        GLfloat("x", uniX)
    )

    void(
        "ProgramUniform2f",
        "Specifies the value of a vec2 uniform variable for a specified program object.",

        GLuint("program", uniProgram),
        GLint("location", uniLocation),
        GLfloat("x", uniX),
        GLfloat("y", uniY)
    )

    void(
        "ProgramUniform3f",
        "Specifies the value of a vec3 uniform variable for a specified program object.",

        GLuint("program", uniProgram),
        GLint("location", uniLocation),
        GLfloat("x", uniX),
        GLfloat("y", uniY),
        GLfloat("z", uniZ)
    )

    void(
        "ProgramUniform4f",
        "Specifies the value of a vec4 uniform variable for a specified program object.",

        GLuint("program", uniProgram),
        GLint("location", uniLocation),
        GLfloat("x", uniX),
        GLfloat("y", uniY),
        GLfloat("z", uniZ),
        GLfloat("w", uniW)
    )

    void(
        "ProgramUniform1d",
        "Specifies the value of a double uniform variable for a specified program object.",

        GLuint("program", uniProgram),
        GLint("location", uniLocation),
        GLdouble("x", uniX)
    )

    void(
        "ProgramUniform2d",
        "Specifies the value of a dvec2 uniform variable for a specified program object.",

        GLuint("program", uniProgram),
        GLint("location", uniLocation),
        GLdouble("x", uniX),
        GLdouble("y", uniY)
    )

    void(
        "ProgramUniform3d",
        "Specifies the value of a dvec3 uniform variable for a specified program object.",

        GLuint("program", uniProgram),
        GLint("location", uniLocation),
        GLdouble("x", uniX),
        GLdouble("y", uniY),
        GLdouble("z", uniZ)
    )

    void(
        "ProgramUniform4d",
        "Specifies the value of a dvec4 uniform variable for a specified program object.",

        GLuint("program", uniProgram),
        GLint("location", uniLocation),
        GLdouble("x", uniX),
        GLdouble("y", uniY),
        GLdouble("z", uniZ),
        GLdouble("w", uniW)
    )

    void(
        "ProgramUniform1iv",
        "Specifies the value of a single float uniform variable or a float uniform variable array for a specified program object.",

        GLuint("program", uniProgram),
        GLint("location", uniLocation),
        AutoSize("value")..GLsizei("count", uniArrayCount),
        GLint.const.p("value", uniArrayValue)
    )

    void(
        "ProgramUniform2iv",
        "Specifies the value of a single ivec2 uniform variable or an ivec2 uniform variable array for a specified program object.",

        GLuint("program", uniProgram),
        GLint("location", uniLocation),
        AutoSize(2, "value")..GLsizei("count", uniArrayCount),
        GLint.const.p("value", uniArrayValue)
    )

    void(
        "ProgramUniform3iv",
        "Specifies the value of a single ivec3 uniform variable or an ivec3 uniform variable array for a specified program object.",

        GLuint("program", uniProgram),
        GLint("location", uniLocation),
        AutoSize(3, "value")..GLsizei("count", uniArrayCount),
        GLint.const.p("value", uniArrayValue)
    )

    void(
        "ProgramUniform4iv",
        "Specifies the value of a single ivec4 uniform variable or an ivec4 uniform variable array for a specified program object.",

        GLuint("program", uniProgram),
        GLint("location", uniLocation),
        AutoSize(4, "value")..GLsizei("count", uniArrayCount),
        GLint.const.p("value", uniArrayValue)
    )

    void(
        "ProgramUniform1uiv",
        "Specifies the value of a single uint uniform variable or a uint uniform variable array for a specified program object.",

        GLuint("program", uniProgram),
        GLint("location", uniLocation),
        AutoSize("value")..GLsizei("count", uniArrayCount),
        GLuint.const.p("value", uniArrayValue)
    )

    void(
        "ProgramUniform2uiv",
        "Specifies the value of a single uvec2 uniform variable or a uvec2 uniform variable array for a specified program object.",

        GLuint("program", uniProgram),
        GLint("location", uniLocation),
        AutoSize(2, "value")..GLsizei("count", uniArrayCount),
        GLuint.const.p("value", uniArrayValue)
    )

    void(
        "ProgramUniform3uiv",
        "Specifies the value of a single uvec3 uniform variable or a uvec3 uniform variable array for a specified program object.",

        GLuint("program", uniProgram),
        GLint("location", uniLocation),
        AutoSize(3, "value")..GLsizei("count", uniArrayCount),
        GLuint.const.p("value", uniArrayValue)
    )

    void(
        "ProgramUniform4uiv",
        "Specifies the value of a single uvec4 uniform variable or a uvec4 uniform variable array for a specified program object.",

        GLuint("program", uniProgram),
        GLint("location", uniLocation),
        AutoSize(4, "value")..GLsizei("count", uniArrayCount),
        GLuint.const.p("value", uniArrayValue)
    )

    void(
        "ProgramUniform1fv",
        "Specifies the value of a single float uniform variable or a float uniform variable array for a specified program object.",

        GLuint("program", uniProgram),
        GLint("location", uniLocation),
        AutoSize("value")..GLsizei("count", uniArrayCount),
        GLfloat.const.p("value", uniArrayValue)
    )

    void(
        "ProgramUniform2fv",
        "Specifies the value of a single vec2 uniform variable or a vec2 uniform variable array for a specified program object.",

        GLuint("program", uniProgram),
        GLint("location", uniLocation),
        AutoSize(2, "value")..GLsizei("count", uniArrayCount),
        GLfloat.const.p("value", uniArrayValue)
    )

    void(
        "ProgramUniform3fv",
        "Specifies the value of a single vec3 uniform variable or a vec3 uniform variable array for a specified program object.",

        GLuint("program", uniProgram),
        GLint("location", uniLocation),
        AutoSize(3, "value")..GLsizei("count", uniArrayCount),
        GLfloat.const.p("value", uniArrayValue)
    )

    void(
        "ProgramUniform4fv",
        "Specifies the value of a single vec4 uniform variable or a vec4 uniform variable array for a specified program object.",

        GLuint("program", uniProgram),
        GLint("location", uniLocation),
        AutoSize(4, "value")..GLsizei("count", uniArrayCount),
        GLfloat.const.p("value", uniArrayValue)
    )

    void(
        "ProgramUniform1dv",
        "Specifies the value of a single double uniform variable or a double uniform variable array for a specified program object.",

        GLuint("program", uniProgram),
        GLint("location", uniLocation),
        AutoSize("value")..GLsizei("count", uniArrayCount),
        GLdouble.const.p("value", uniArrayValue)
    )

    void(
        "ProgramUniform2dv",
        "Specifies the value of a single dvec2 uniform variable or a dvec2 uniform variable array for a specified program object.",

        GLuint("program", uniProgram),
        GLint("location", uniLocation),
        AutoSize(2, "value")..GLsizei("count", uniArrayCount),
        GLdouble.const.p("value", uniArrayValue)
    )

    void(
        "ProgramUniform3dv",
        "Specifies the value of a single dvec3 uniform variable or a dvec3 uniform variable array for a specified program object.",

        GLuint("program", uniProgram),
        GLint("location", uniLocation),
        AutoSize(3, "value")..GLsizei("count", uniArrayCount),
        GLdouble.const.p("value", uniArrayValue)
    )

    void(
        "ProgramUniform4dv",
        "Specifies the value of a single dvec4 uniform variable or a dvec4 uniform variable array for a specified program object.",

        GLuint("program", uniProgram),
        GLint("location", uniLocation),
        AutoSize(4, "value")..GLsizei("count", uniArrayCount),
        GLdouble.const.p("value", uniArrayValue)
    )

    void(
        "ProgramUniformMatrix2fv",
        "Specifies the value of a single mat2 uniform variable or a mat2 uniform variable array for the current program object.",

        GLuint("program", uniProgram),
        GLint("location", uniLocation),
        AutoSize(2 x 2, "value")..GLsizei("count", uniMatrixCount),
        GLboolean("transpose", uniMatrixTranspose),
        GLfloat.const.p("value", uniMatrixValue)
    )

    void(
        "ProgramUniformMatrix3fv",
        "Specifies the value of a single mat3 uniform variable or a mat3 uniform variable array for the current program object.",

        GLuint("program", uniProgram),
        GLint("location", uniLocation),
        AutoSize(3 x 3, "value")..GLsizei("count", uniMatrixCount),
        GLboolean("transpose", uniMatrixTranspose),
        GLfloat.const.p("value", uniMatrixValue)
    )

    void(
        "ProgramUniformMatrix4fv",
        "Specifies the value of a single mat4 uniform variable or a mat4 uniform variable array for the current program object.",

        GLuint("program", uniProgram),
        GLint("location", uniLocation),
        AutoSize(4 x 4, "value")..GLsizei("count", uniMatrixCount),
        GLboolean("transpose", uniMatrixTranspose),
        GLfloat.const.p("value", uniMatrixValue)
    )

    void(
        "ProgramUniformMatrix2dv",
        "Specifies the value of a single dmat2 uniform variable or a dmat2 uniform variable array for the current program object.",

        GLuint("program", uniProgram),
        GLint("location", uniLocation),
        AutoSize(2 x 2, "value")..GLsizei("count", uniMatrixCount),
        GLboolean("transpose", uniMatrixTranspose),
        GLdouble.const.p("value", uniMatrixValue)
    )

    void(
        "ProgramUniformMatrix3dv",
        "Specifies the value of a single dmat3 uniform variable or a dmat3 uniform variable array for the current program object.",

        GLuint("program", uniProgram),
        GLint("location", uniLocation),
        AutoSize(3 x 3, "value")..GLsizei("count", uniMatrixCount),
        GLboolean("transpose", uniMatrixTranspose),
        GLdouble.const.p("value", uniMatrixValue)
    )

    void(
        "ProgramUniformMatrix4dv",
        "Specifies the value of a single dmat4 uniform variable or a dmat4 uniform variable array for the current program object.",

        GLuint("program", uniProgram),
        GLint("location", uniLocation),
        AutoSize(4 x 4, "value")..GLsizei("count", uniMatrixCount),
        GLboolean("transpose", uniMatrixTranspose),
        GLdouble.const.p("value", uniMatrixValue)
    )

    void(
        "ProgramUniformMatrix2x3fv",
        "Specifies the value of a single mat2x3 uniform variable or a mat2x3 uniform variable array for the current program object.",

        GLuint("program", uniProgram),
        GLint("location", uniLocation),
        AutoSize(2 x 3, "value")..GLsizei("count", uniMatrixCount),
        GLboolean("transpose", uniMatrixTranspose),
        GLfloat.const.p("value", uniMatrixValue)
    )

    void(
        "ProgramUniformMatrix3x2fv",
        "Specifies the value of a single mat3x2 uniform variable or a mat3x2 uniform variable array for the current program object.",

        GLuint("program", uniProgram),
        GLint("location", uniLocation),
        AutoSize(3 x 2, "value")..GLsizei("count", uniMatrixCount),
        GLboolean("transpose", uniMatrixTranspose),
        GLfloat.const.p("value", uniMatrixValue)
    )

    void(
        "ProgramUniformMatrix2x4fv",
        "Specifies the value of a single mat2x4 uniform variable or a mat2x4 uniform variable array for the current program object.",

        GLuint("program", uniProgram),
        GLint("location", uniLocation),
        AutoSize(2 x 4, "value")..GLsizei("count", uniMatrixCount),
        GLboolean("transpose", uniMatrixTranspose),
        GLfloat.const.p("value", uniMatrixValue)
    )

    void(
        "ProgramUniformMatrix4x2fv",
        "Specifies the value of a single mat4x2 uniform variable or a mat4x2 uniform variable array for the current program object.",

        GLuint("program", uniProgram),
        GLint("location", uniLocation),
        AutoSize(4 x 2, "value")..GLsizei("count", uniMatrixCount),
        GLboolean("transpose", uniMatrixTranspose),
        GLfloat.const.p("value", uniMatrixValue)
    )

    void(
        "ProgramUniformMatrix3x4fv",
        "Specifies the value of a single mat3x4 uniform variable or a mat3x4 uniform variable array for the current program object.",

        GLuint("program", uniProgram),
        GLint("location", uniLocation),
        AutoSize(3 x 4, "value")..GLsizei("count", uniMatrixCount),
        GLboolean("transpose", uniMatrixTranspose),
        GLfloat.const.p("value", uniMatrixValue)
    )

    void(
        "ProgramUniformMatrix4x3fv",
        "Specifies the value of a single mat4x3 uniform variable or a mat4x3 uniform variable array for the current program object.",

        GLuint("program", uniProgram),
        GLint("location", uniLocation),
        AutoSize(4 x 3, "value")..GLsizei("count", uniMatrixCount),
        GLboolean("transpose", uniMatrixTranspose),
        GLfloat.const.p("value", uniMatrixValue)
    )

    void(
        "ProgramUniformMatrix2x3dv",
        "Specifies the value of a single dmat2x3 uniform variable or a dmat2x3 uniform variable array for the current program object.",

        GLuint("program", uniProgram),
        GLint("location", uniLocation),
        AutoSize(2 x 3, "value")..GLsizei("count", uniMatrixCount),
        GLboolean("transpose", uniMatrixTranspose),
        GLdouble.const.p("value", uniMatrixValue)
    )

    void(
        "ProgramUniformMatrix3x2dv",
        "Specifies the value of a single dmat3x2 uniform variable or a dmat3x2 uniform variable array for the current program object.",

        GLuint("program", uniProgram),
        GLint("location", uniLocation),
        AutoSize(3 x 2, "value")..GLsizei("count", uniMatrixCount),
        GLboolean("transpose", uniMatrixTranspose),
        GLdouble.const.p("value", uniMatrixValue)
    )

    void(
        "ProgramUniformMatrix2x4dv",
        "Specifies the value of a single dmat2x4 uniform variable or a dmat2x4 uniform variable array for the current program object.",

        GLuint("program", uniProgram),
        GLint("location", uniLocation),
        AutoSize(2 x 4, "value")..GLsizei("count", uniMatrixCount),
        GLboolean("transpose", uniMatrixTranspose),
        GLdouble.const.p("value", uniMatrixValue)
    )

    void(
        "ProgramUniformMatrix4x2dv",
        "Specifies the value of a single dmat4x2 uniform variable or a dmat4x2 uniform variable array for the current program object.",

        GLuint("program", uniProgram),
        GLint("location", uniLocation),
        AutoSize(4 x 2, "value")..GLsizei("count", uniMatrixCount),
        GLboolean("transpose", uniMatrixTranspose),
        GLdouble.const.p("value", uniMatrixValue)
    )

    void(
        "ProgramUniformMatrix3x4dv",
        "Specifies the value of a single dmat3x4 uniform variable or a dmat3x4 uniform variable array for the current program object.",

        GLuint("program", uniProgram),
        GLint("location", uniLocation),
        AutoSize(3 x 4, "value")..GLsizei("count", uniMatrixCount),
        GLboolean("transpose", uniMatrixTranspose),
        GLdouble.const.p("value", uniMatrixValue)
    )

    void(
        "ProgramUniformMatrix4x3dv",
        "Specifies the value of a single dmat4x3 uniform variable or a dmat4x3 uniform variable array for the current program object.",

        GLuint("program", uniProgram),
        GLint("location", uniLocation),
        AutoSize(4 x 3, "value")..GLsizei("count", uniMatrixCount),
        GLboolean("transpose", uniMatrixTranspose),
        GLdouble.const.p("value", uniMatrixValue)
    )

    void(
        "ValidateProgramPipeline",
        "Validates a program pipeline object against current GL state.",

        GLuint("pipeline", "the name of a program pipeline object to validate")
    )

    void(
        "GetProgramPipelineInfoLog",
        "Retrieves the info log string from a program pipeline object.",

        GLuint("pipeline", "the name of a program pipeline object from which to retrieve the info log"),
        AutoSize("infoLog")..GLsizei("bufSize", "the maximum number of characters, including the null terminator, that may be written into {@code infoLog}"),
        Check(1)..nullable..GLsizei.p("length", "a variable into which will be written the number of characters written into {@code infoLog}"),
        Return(
            "length",
            "glGetProgramPipelinei(pipeline, GL20.GL_INFO_LOG_LENGTH)",
            heapAllocate = true
        )..GLcharUTF8.p("infoLog", "an array of characters into which will be written the info log for {@code pipeline}")
    )

    // ARB_vertex_attrib_64bit

    // Vertex attrib functions javadoc
    val attribIndex = "the index of the generic vertex attribute to be modified"
    val attribX = "the vertex attribute x component"
    val attribY = "the vertex attribute y component"
    val attribZ = "the vertex attribute z component"
    val attribW = "the vertex attribute w component"
    val attribBuffer = "the vertex attribute buffer"

    void(
        "VertexAttribL1d",
        "Specifies the value of a generic vertex attribute. The y and z components are implicitly set to 0.0 and w to 1.0.",

        GLuint("index", attribIndex),
        GLdouble("x", attribX)
    )

    void(
        "VertexAttribL2d",
        "Specifies the value of a generic vertex attribute. The y component is implicitly set to 0.0 and w to 1.0.",

        GLuint("index", attribIndex),
        GLdouble("x", attribX),
        GLdouble("y", attribY)
    )

    void(
        "VertexAttribL3d",
        "Specifies the value of a generic vertex attribute. The w is implicitly set to 1.0.",

        GLuint("index", attribIndex),
        GLdouble("x", attribX),
        GLdouble("y", attribY),
        GLdouble("z", attribZ)
    )

    void(
        "VertexAttribL4d",
        "Specifies the value of a generic vertex attribute.",

        GLuint("index", attribIndex),
        GLdouble("x", attribX),
        GLdouble("y", attribY),
        GLdouble("z", attribZ),
        GLdouble("w", attribW)
    )

    void("VertexAttribL1dv", "Pointer version of #VertexAttribL1d().", GLuint("index", attribIndex), Check(1)..GLdouble.const.p("v", attribBuffer))
    void("VertexAttribL2dv", "Pointer version of #VertexAttribL2d().", GLuint("index", attribIndex), Check(2)..GLdouble.const.p("v", attribBuffer))
    void("VertexAttribL3dv", "Pointer version of #VertexAttribL3d().", GLuint("index", attribIndex), Check(3)..GLdouble.const.p("v", attribBuffer))
    void("VertexAttribL4dv", "Pointer version of #VertexAttribL4d().", GLuint("index", attribIndex), Check(4)..GLdouble.const.p("v", attribBuffer))

    OffHeapOnly..void(
        "VertexAttribLPointer",
        "Specifies the location and organization of a 64-bit vertex attribute array.",

        GLuint("index", attribIndex),
        GLint("size", "the number of values per vertex that are stored in the array. The initial value is 4", "1 2 3 4 #BGRA"),
        AutoType("pointer", GL_DOUBLE)..GLenum("type", "the data type of each component in the array", "#DOUBLE"),
        GLsizei(
            "stride",
            """
            the byte offset between consecutive generic vertex attributes. If stride is 0, the generic vertex attributes are understood to be tightly packed in
            the array. The initial value is 0.
            """
        ),
        Unsafe..RawPointer..void.const.p(
            "pointer",
            """
            the vertex attribute data or the offset of the first component of the first generic vertex attribute in the array in the data store of the buffer
            currently bound to the #ARRAY_BUFFER target. The initial value is 0.
            """
        )
    )

    void(
        "GetVertexAttribLdv",
        "Double version of #GetVertexAttribiv().",

        GLuint("index", "the generic vertex attribute parameter to be queried"),
        GLenum("pname", "the symbolic name of the vertex attribute parameter to be queried"),
        Check(1)..GLdouble.p("params", "the requested data")
    )

    // ARB_viewport_array

    IntConstant(
        "Accepted by the {@code pname} parameter of GetBooleanv, GetIntegerv, GetFloatv, GetDoublev and GetInteger64v.",

        "MAX_VIEWPORTS"..0x825B,
        "VIEWPORT_SUBPIXEL_BITS"..0x825C,
        "VIEWPORT_BOUNDS_RANGE"..0x825D,
        "LAYER_PROVOKING_VERTEX"..0x825E,
        "VIEWPORT_INDEX_PROVOKING_VERTEX"..0x825F
    )

    IntConstant(
        "Returned in the {@code data} parameter from a Get query with a {@code pname} of LAYER_PROVOKING_VERTEX or VIEWPORT_INDEX_PROVOKING_VERTEX.",

        "UNDEFINED_VERTEX"..0x8260
    )

    void(
        "ViewportArrayv",
        "Sets multiple viewports.",

        GLuint("first", "the first viewport to set"),
        AutoSize(4, "v")..GLsizei("count", "the number of viewports to set"),
        GLfloat.const.p("v", "an array containing the viewport parameters")
    )

    void(
        "ViewportIndexedf",
        "Sets a specified viewport.",

        GLuint("index", "the viewport to set"),
        GLfloat("x", "the left viewport coordinate"),
        GLfloat("y", "the bottom viewport coordinate"),
        GLfloat("w", "the viewport width"),
        GLfloat("h", "the viewport height")
    )

    void(
        "ViewportIndexedfv",
        "Pointer version of #ViewportIndexedf().",

        GLuint("index", "the viewport to set"),
        Check(4)..GLfloat.const.p("v", "the viewport parameters")
    )

    void(
        "ScissorArrayv",
        "Defines the scissor box for multiple viewports.",

        GLuint("first", "the index of the first viewport whose scissor box to modify"),
        AutoSize(4, "v")..GLsizei("count", "the number of scissor boxes to modify"),
        GLint.const.p("v", "an array containing the left, bottom, width and height of each scissor box, in that order")
    )

    void(
        "ScissorIndexed",
        "Defines the scissor box for a specific viewport.",

        GLuint("index", "the index of the viewport whose scissor box to modify"),
        GLint("left", "the left scissor box coordinate"),
        GLint("bottom", "the bottom scissor box coordinate"),
        GLsizei("width", "the scissor box width"),
        GLsizei("height", "the scissor box height")
    )

    void(
        "ScissorIndexedv",
        "Pointer version of #ScissorIndexed().",

        GLuint("index", "the index of the viewport whose scissor box to modify"),
        Check(4)..GLint.const.p("v", "an array containing the left, bottom, width and height of each scissor box, in that order")
    )

    void(
        "DepthRangeArrayv",
        "Specifies mapping of depth values from normalized device coordinates to window coordinates for a specified set of viewports.",

        GLuint("first", "the index of the first viewport whose depth range to update"),
        AutoSize(2, "v")..GLsizei("count", "the number of viewports whose depth range to update"),
        GLdouble.const.p("v", "n array containing the near and far values for the depth range of each modified viewport")
    )

    void(
        "DepthRangeIndexed",
        "Specifies mapping of depth values from normalized device coordinates to window coordinates for a specified viewport.",

        GLuint("index", "the index of the viewport whose depth range to update"),
        GLdouble("zNear", "the mapping of the near clipping plane to window coordinates. The initial value is 0."),
        GLdouble("zFar", "the mapping of the far clipping plane to window coordinates. The initial value is 1.")
    )

    void(
        "GetFloati_v",
        "Queries the float value of an indexed state variable.",

        GLenum("target", "the indexed state to query"),
        GLuint("index", "the index of the element being queried"),
        Check(1)..ReturnParam..GLfloat.p("data", "a scalar or buffer in which to place the returned data")
    )

    void(
        "GetDoublei_v",
        "Queries the double value of an indexed state variable.",

        GLenum("target", "the indexed state to query"),
        GLuint("index", "the index of the element being queried"),
        Check(1)..ReturnParam..GLdouble.p("data", "a scalar or buffer in which to place the returned data")
    )
}