/*
 * Copyright LWJGL. All rights reserved.
 * License terms: https://www.lwjgl.org/license
 */
package opengles.templates

import org.lwjgl.generator.*
import opengles.*

val EXT_separate_shader_objects = "EXTSeparateShaderObjects".nativeClassGLES("EXT_separate_shader_objects", postfix = EXT) {
    documentation =
        """
        Native bindings to the ${registryLink("EXT_separate_shader_objects.gles")} extension.

        This extension is a subset of ARB_separate_shader_objects appropriate for OpenGL ES, and also tacks on ARB_explicit_attrib_location functionality.

        Conventional GLSL requires multiple shader stages (vertex and fragment) to be linked into a single monolithic program object to specify a GLSL shader
        for each stage.

        While GLSL's monolithic approach has some advantages for optimizing shaders as a unit that span multiple stages, GPU hardware supports a more flexible
        mix-and-match approach to specifying shaders independently for these different shader stages. Many developers build their shader content around the
        mix-and-match approach where they can use a single vertex shader with multiple fragment shaders (or vice versa).

        This extension adopts a "mix-and-match" shader stage model for GLSL allowing multiple different GLSL program objects to be bound at once each to an
        individual rendering pipeline stage independently of other stage bindings. This allows program objects to contain only the shader stages that best suit
        the application's needs.

        This extension introduces the program pipeline object that serves as a container for the program bound to any particular rendering stage. It can be
        bound, unbound, and rebound to simply save and restore the complete shader stage to program object bindings. Like framebuffer and vertex array objects,
        program pipeline objects are "container" objects that are not shared between contexts.

        To bind a program object to a specific shader stage or set of stages, UseProgramStagesEXT is used. The VERTEX_SHADER_BIT_EXT and
        FRAGMENT_SHADER_BIT_EXT tokens refer to the conventional vertex and fragment stages, respectively. ActiveShaderProgramEXT specifies the program that
        Uniform* commands will update.

        While ActiveShaderProgramEXT provides a selector for setting and querying uniform values of a program object with the conventional Uniform* commands,
        the ProgramUniform* commands provide a selector-free way to modify uniforms of a GLSL program object without an explicit bind. This selector-free model
        reduces API overhead and provides a cleaner interface for applications.

        Separate linking creates the possibility that certain output varyings of a shader may go unread by the subsequent shader input varyings. In this case,
        the output varyings are simply ignored. It is also possible input varyings from a shader may not be written as output varyings of a preceding shader.
        In this case, the unwritten input varying values are undefined.

        This extension also introduces a layout location qualifier to GLSL to pre- assign attribute and varying locations to shader variables. This allows
        applications to globally assign a particular semantic meaning, such as diffuse color or vertex normal, to a particular attribute and/or varying
        location without knowing how that variable will be named in any particular shader.

        Requires ${GLES20.core}.
        """

    IntConstant(
        "Accepted by {@code stages} parameter to UseProgramStagesEXT.",

        "VERTEX_SHADER_BIT_EXT"..0x00000001,
        "FRAGMENT_SHADER_BIT_EXT"..0x00000002,
        "ALL_SHADER_BITS_EXT".."0xFFFFFFFF"
    )

    IntConstant(
        "Accepted by the {@code pname} parameter of ProgramParameteriEXT and GetProgramiv.",

        "PROGRAM_SEPARABLE_EXT"..0x8258
    )

    IntConstant(
        "Accepted by {@code type} parameter to GetProgramPipelineivEXT.",

        "ACTIVE_PROGRAM_EXT"..0x8259
    )

    IntConstant(
        "Accepted by the {@code pname} parameter of GetBooleanv, GetIntegerv, and GetFloatv.",

        "PROGRAM_PIPELINE_BINDING_EXT"..0x825A
    )

    void(
        "ActiveShaderProgramEXT",
        "",

        GLuint("pipeline", ""),
        GLuint("program", "")
    )

    void(
        "BindProgramPipelineEXT",
        "",

        GLuint("pipeline", "")
    )

    GLuint(
        "CreateShaderProgramvEXT",
        "",

        GLenum("type", ""),
        AutoSize("strings")..GLsizei("count", ""),
        PointerArray(GLcharUTF8.p, "string")..GLcharUTF8.const.p.const.p("strings", "")
    )

    void(
        "DeleteProgramPipelinesEXT",
        "",

        AutoSize("pipelines")..GLsizei("n", ""),
        SingleValue("pipeline")..GLuint.const.p("pipelines", "")
    )

    void(
        "GenProgramPipelinesEXT",
        "",

        AutoSize("pipelines")..GLsizei("n", ""),
        ReturnParam..GLuint.p("pipelines", "")
    )

    void(
        "GetProgramPipelineInfoLogEXT",
        "",

        GLuint("pipeline", ""),
        AutoSize("infoLog")..GLsizei("bufSize", ""),
        Check(1)..nullable..GLsizei.p("length", ""),
        Return(
            "length",
            "glGetProgramPipelineiEXT(pipeline, GLES20.GL_INFO_LOG_LENGTH)",
            heapAllocate = true
        )..GLcharUTF8.p("infoLog", "")
    )

    void(
        "GetProgramPipelineivEXT",
        "",

        GLuint("pipeline", ""),
        GLenum("pname", ""),
        ReturnParam..Check(1)..GLint.p("params", "")
    )

    GLboolean(
        "IsProgramPipelineEXT",
        "",

        GLuint("pipeline", "")
    )

    void(
        "ProgramParameteriEXT",
        "",

        GLuint("program", ""),
        GLenum("pname", ""),
        GLint("value", "")
    )

    void(
        "ProgramUniform1fEXT",
        "",

        GLuint("program", ""),
        GLint("location", ""),
        GLfloat("v0", "")
    )

    void(
        "ProgramUniform1fvEXT",
        "",

        GLuint("program", ""),
        GLint("location", ""),
        AutoSize("value")..GLsizei("count", ""),
        GLfloat.const.p("value", "")
    )

    void(
        "ProgramUniform1iEXT",
        "",

        GLuint("program", ""),
        GLint("location", ""),
        GLint("v0", "")
    )

    void(
        "ProgramUniform1ivEXT",
        "",

        GLuint("program", ""),
        GLint("location", ""),
        AutoSize("value")..GLsizei("count", ""),
        GLint.const.p("value", "")
    )

    void(
        "ProgramUniform2fEXT",
        "",

        GLuint("program", ""),
        GLint("location", ""),
        GLfloat("v0", ""),
        GLfloat("v1", "")
    )

    void(
        "ProgramUniform2fvEXT",
        "",

        GLuint("program", ""),
        GLint("location", ""),
        AutoSize(2, "value")..GLsizei("count", ""),
        GLfloat.const.p("value", "")
    )

    void(
        "ProgramUniform2iEXT",
        "",

        GLuint("program", ""),
        GLint("location", ""),
        GLint("v0", ""),
        GLint("v1", "")
    )

    void(
        "ProgramUniform2ivEXT",
        "",

        GLuint("program", ""),
        GLint("location", ""),
        AutoSize(2, "value")..GLsizei("count", ""),
        GLint.const.p("value", "")
    )

    void(
        "ProgramUniform3fEXT",
        "",

        GLuint("program", ""),
        GLint("location", ""),
        GLfloat("v0", ""),
        GLfloat("v1", ""),
        GLfloat("v2", "")
    )

    void(
        "ProgramUniform3fvEXT",
        "",

        GLuint("program", ""),
        GLint("location", ""),
        AutoSize(3, "value")..GLsizei("count", ""),
        GLfloat.const.p("value", "")
    )

    void(
        "ProgramUniform3iEXT",
        "",

        GLuint("program", ""),
        GLint("location", ""),
        GLint("v0", ""),
        GLint("v1", ""),
        GLint("v2", "")
    )

    void(
        "ProgramUniform3ivEXT",
        "",

        GLuint("program", ""),
        GLint("location", ""),
        AutoSize(3, "value")..GLsizei("count", ""),
        GLint.const.p("value", "")
    )

    void(
        "ProgramUniform4fEXT",
        "",

        GLuint("program", ""),
        GLint("location", ""),
        GLfloat("v0", ""),
        GLfloat("v1", ""),
        GLfloat("v2", ""),
        GLfloat("v3", "")
    )

    void(
        "ProgramUniform4fvEXT",
        "",

        GLuint("program", ""),
        GLint("location", ""),
        AutoSize(4, "value")..GLsizei("count", ""),
        GLfloat.const.p("value", "")
    )

    void(
        "ProgramUniform4iEXT",
        "",

        GLuint("program", ""),
        GLint("location", ""),
        GLint("v0", ""),
        GLint("v1", ""),
        GLint("v2", ""),
        GLint("v3", "")
    )

    void(
        "ProgramUniform4ivEXT",
        "",

        GLuint("program", ""),
        GLint("location", ""),
        AutoSize(4, "value")..GLsizei("count", ""),
        GLint.const.p("value", "")
    )

    void(
        "ProgramUniformMatrix2fvEXT",
        "",

        GLuint("program", ""),
        GLint("location", ""),
        AutoSize(2 x 2, "value")..GLsizei("count", ""),
        GLboolean("transpose", ""),
        GLfloat.const.p("value", "")
    )

    void(
        "ProgramUniformMatrix3fvEXT",
        "",

        GLuint("program", ""),
        GLint("location", ""),
        AutoSize(3 x 3, "value")..GLsizei("count", ""),
        GLboolean("transpose", ""),
        GLfloat.const.p("value", "")
    )

    void(
        "ProgramUniformMatrix4fvEXT",
        "",

        GLuint("program", ""),
        GLint("location", ""),
        AutoSize(4 x 4, "value")..GLsizei("count", ""),
        GLboolean("transpose", ""),
        GLfloat.const.p("value", "")
    )

    void(
        "UseProgramStagesEXT",
        "",

        GLuint("pipeline", ""),
        GLbitfield("stages", ""),
        GLuint("program", "")
    )

    void(
        "ValidateProgramPipelineEXT",
        "",

        GLuint("pipeline", "")
    )

    void(
        "ProgramUniform1uiEXT",
        "",

        GLuint("program", ""),
        GLint("location", ""),
        GLuint("v0", "")
    )

    void(
        "ProgramUniform2uiEXT",
        "",

        GLuint("program", ""),
        GLint("location", ""),
        GLuint("v0", ""),
        GLuint("v1", "")
    )

    void(
        "ProgramUniform3uiEXT",
        "",

        GLuint("program", ""),
        GLint("location", ""),
        GLuint("v0", ""),
        GLuint("v1", ""),
        GLuint("v2", "")
    )

    void(
        "ProgramUniform4uiEXT",
        "",

        GLuint("program", ""),
        GLint("location", ""),
        GLuint("v0", ""),
        GLuint("v1", ""),
        GLuint("v2", ""),
        GLuint("v3", "")
    )

    void(
        "ProgramUniform1uivEXT",
        "",

        GLuint("program", ""),
        GLint("location", ""),
        AutoSize("value")..GLsizei("count", ""),
        GLuint.const.p("value", "")
    )

    void(
        "ProgramUniform2uivEXT",
        "",

        GLuint("program", ""),
        GLint("location", ""),
        AutoSize(2, "value")..GLsizei("count", ""),
        GLuint.const.p("value", "")
    )

    void(
        "ProgramUniform3uivEXT",
        "",

        GLuint("program", ""),
        GLint("location", ""),
        AutoSize(3, "value")..GLsizei("count", ""),
        GLuint.const.p("value", "")
    )

    void(
        "ProgramUniform4uivEXT",
        "",

        GLuint("program", ""),
        GLint("location", ""),
        AutoSize(4, "value")..GLsizei("count", ""),
        GLuint.const.p("value", "")
    )

    void(
        "ProgramUniformMatrix2x3fvEXT",
        "",

        GLuint("program", ""),
        GLint("location", ""),
        AutoSize(2 x 3, "value")..GLsizei("count", ""),
        GLboolean("transpose", ""),
        GLfloat.const.p("value", "")
    )

    void(
        "ProgramUniformMatrix3x2fvEXT",
        "",

        GLuint("program", ""),
        GLint("location", ""),
        AutoSize(3 x 2, "value")..GLsizei("count", ""),
        GLboolean("transpose", ""),
        GLfloat.const.p("value", "")
    )

    void(
        "ProgramUniformMatrix2x4fvEXT",
        "",

        GLuint("program", ""),
        GLint("location", ""),
        AutoSize(2 x 4, "value")..GLsizei("count", ""),
        GLboolean("transpose", ""),
        GLfloat.const.p("value", "")
    )

    void(
        "ProgramUniformMatrix4x2fvEXT",
        "",

        GLuint("program", ""),
        GLint("location", ""),
        AutoSize(4 x 2, "value")..GLsizei("count", ""),
        GLboolean("transpose", ""),
        GLfloat.const.p("value", "")
    )

    void(
        "ProgramUniformMatrix3x4fvEXT",
        "",

        GLuint("program", ""),
        GLint("location", ""),
        AutoSize(3 x 4, "value")..GLsizei("count", ""),
        GLboolean("transpose", ""),
        GLfloat.const.p("value", "")
    )

    void(
        "ProgramUniformMatrix4x3fvEXT",
        "",

        GLuint("program", ""),
        GLint("location", ""),
        AutoSize(4 x 3, "value")..GLsizei("count", ""),
        GLboolean("transpose", ""),
        GLfloat.const.p("value", "")
    )
}