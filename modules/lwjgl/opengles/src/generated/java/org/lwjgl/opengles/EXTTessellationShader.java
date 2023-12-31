/*
 * Copyright LWJGL. All rights reserved.
 * License terms: https://www.lwjgl.org/license
 * MACHINE GENERATED FILE, DO NOT EDIT
 */
package org.lwjgl.opengles;

import org.lwjgl.system.*;

/**
 * Native bindings to the <a href="https://www.khronos.org/registry/OpenGL/extensions/EXT/EXT_tessellation_shader.txt">EXT_tessellation_shader</a> extension.
 * 
 * <p>This extension introduces new tessellation stages and two new shader types to the OpenGL ES primitive processing pipeline. These pipeline stages
 * operate on a new basic primitive type, called a patch. A patch consists of a fixed-size collection of vertices, each with per-vertex attributes, plus a
 * number of associated per-patch attributes. Tessellation control shaders transform an input patch specified by the application, computing per-vertex and
 * per-patch attributes for a new output patch. A fixed-function tessellation primitive generator subdivides the patch, and tessellation evaluation
 * shaders are used to compute the position and attributes of each vertex produced by the tessellator.</p>
 * 
 * <p>When tessellation is active, it begins by running the optional tessellation control shader. This shader consumes an input patch and produces a new
 * fixed-size output patch. The output patch consists of an array of vertices, and a set of per-patch attributes. The per-patch attributes include
 * tessellation levels that control how finely the patch will be tessellated. For each patch processed, multiple tessellation control shader invocations
 * are performed -- one per output patch vertex. Each tessellation control shader invocation writes all the attributes of its corresponding output patch
 * vertex. A tessellation control shader may also read the per-vertex outputs of other tessellation control shader invocations, as well as read and write
 * shared per-patch outputs. The tessellation control shader invocations for a single patch effectively run as a group. A built-in barrier() function is
 * provided to allow synchronization points where no shader invocation will continue until all shader invocations have reached the barrier.</p>
 * 
 * <p>The tessellation primitive generator then decomposes a patch into a new set of primitives using the tessellation levels to determine how finely
 * tessellated the output should be. The primitive generator begins with either a triangle or a quad, and splits each outer edge of the primitive into a
 * number of segments approximately equal to the corresponding element of the outer tessellation level array. The interior of the primitive is tessellated
 * according to elements of the inner tessellation level array. The primitive generator has three modes: "triangles" and "quads" split a triangular or
 * quad-shaped patch into a set of triangles that cover the original patch; "isolines" splits a quad-shaped patch into a set of line strips running across
 * the patch horizontally. Each vertex generated by the tessellation primitive generator is assigned a (u,v) or (u,v,w) coordinate indicating its relative
 * location in the subdivided triangle or quad.</p>
 * 
 * <p>For each vertex produced by the tessellation primitive generator, the tessellation evaluation shader is run to compute its position and other
 * attributes of the vertex, using its (u,v) or (u,v,w) coordinate. When computing final vertex attributes, the tessellation evaluation shader can also
 * read the attributes of any of the vertices of the patch written by the tessellation control shader. Tessellation evaluation shader invocations are
 * completely independent, although all invocations for a single patch share the same collection of input vertices and per-patch attributes.</p>
 * 
 * <p>The tessellator operates on vertices after they have been transformed by a vertex shader. The primitives generated by the tessellator are passed
 * further down the OpenGL ES pipeline, where they can be used as inputs to geometry shaders, transform feedback, and the rasterizer.</p>
 * 
 * <p>The tessellation control and evaluation shaders are both optional. If neither shader type is present, the tessellation stage has no effect. However, if
 * either a tessellation control or a tessellation evaluation shader is present, the other must also be present.</p>
 * 
 * <p>Not all tessellation shader implementations have the ability to write the point size from a tessellation shader. Thus a second extension string and
 * shading language enable are provided for implementations which do support tessellation shader point size.</p>
 * 
 * <p>This extension relies on the EXT_shader_io_blocks extension to provide the required functionality for declaring input and output blocks and interfacing
 * between shaders.</p>
 * 
 * <p>This extension relies on the EXT_gpu_shader5 extension to provide the 'precise' and 'fma' functionality which are necessary to ensure crack-free
 * tessellation.</p>
 * 
 * <p>Requires {@link GLES31 GLES 3.1}.</p>
 */
public class EXTTessellationShader {

    static { GLES.initialize(); }

    /** Accepted by the {@code mode} parameter of DrawArrays, DrawElements, and other commands which draw primitives. */
    public static final int GL_PATCHES_EXT = 0xE;

    /** Accepted by the {@code pname} parameter of PatchParameteriEXT, GetBooleanv, GetFloatv, GetIntegerv, and GetInteger64v. */
    public static final int GL_PATCH_VERTICES_EXT = 0x8E72;

    /** Accepted by the {@code pname} parameter of GetProgramiv. */
    public static final int
        GL_TESS_CONTROL_OUTPUT_VERTICES_EXT = 0x8E75,
        GL_TESS_GEN_MODE_EXT                = 0x8E76,
        GL_TESS_GEN_SPACING_EXT             = 0x8E77,
        GL_TESS_GEN_VERTEX_ORDER_EXT        = 0x8E78,
        GL_TESS_GEN_POINT_MODE_EXT          = 0x8E79;

    /** Returned by GetProgramiv when {@code pname} is TESS_GEN_MODE_EXT. */
    public static final int
        GL_ISOLINES_EXT = 0x8E7A,
        GL_QUADS_EXT    = 0x7;

    /** Returned by GetProgramiv when {@code pname} is TESS_GEN_SPACING_EXT. */
    public static final int
        GL_FRACTIONAL_ODD_EXT  = 0x8E7B,
        GL_FRACTIONAL_EVEN_EXT = 0x8E7C;

    /** Accepted by the {@code pname} parameter of GetBooleanv, GetFloatv, GetIntegerv, and GetInteger64v. */
    public static final int
        GL_MAX_PATCH_VERTICES_EXT                              = 0x8E7D,
        GL_MAX_TESS_GEN_LEVEL_EXT                              = 0x8E7E,
        GL_MAX_TESS_CONTROL_UNIFORM_COMPONENTS_EXT             = 0x8E7F,
        GL_MAX_TESS_EVALUATION_UNIFORM_COMPONENTS_EXT          = 0x8E80,
        GL_MAX_TESS_CONTROL_TEXTURE_IMAGE_UNITS_EXT            = 0x8E81,
        GL_MAX_TESS_EVALUATION_TEXTURE_IMAGE_UNITS_EXT         = 0x8E82,
        GL_MAX_TESS_CONTROL_OUTPUT_COMPONENTS_EXT              = 0x8E83,
        GL_MAX_TESS_PATCH_COMPONENTS_EXT                       = 0x8E84,
        GL_MAX_TESS_CONTROL_TOTAL_OUTPUT_COMPONENTS_EXT        = 0x8E85,
        GL_MAX_TESS_EVALUATION_OUTPUT_COMPONENTS_EXT           = 0x8E86,
        GL_MAX_TESS_CONTROL_UNIFORM_BLOCKS_EXT                 = 0x8E89,
        GL_MAX_TESS_EVALUATION_UNIFORM_BLOCKS_EXT              = 0x8E8A,
        GL_MAX_TESS_CONTROL_INPUT_COMPONENTS_EXT               = 0x886C,
        GL_MAX_TESS_EVALUATION_INPUT_COMPONENTS_EXT            = 0x886D,
        GL_MAX_COMBINED_TESS_CONTROL_UNIFORM_COMPONENTS_EXT    = 0x8E1E,
        GL_MAX_COMBINED_TESS_EVALUATION_UNIFORM_COMPONENTS_EXT = 0x8E1F,
        GL_MAX_TESS_CONTROL_ATOMIC_COUNTER_BUFFERS_EXT         = 0x92CD,
        GL_MAX_TESS_EVALUATION_ATOMIC_COUNTER_BUFFERS_EXT      = 0x92CE,
        GL_MAX_TESS_CONTROL_ATOMIC_COUNTERS_EXT                = 0x92D3,
        GL_MAX_TESS_EVALUATION_ATOMIC_COUNTERS_EXT             = 0x92D4,
        GL_MAX_TESS_CONTROL_IMAGE_UNIFORMS_EXT                 = 0x90CB,
        GL_MAX_TESS_EVALUATION_IMAGE_UNIFORMS_EXT              = 0x90CC,
        GL_MAX_TESS_CONTROL_SHADER_STORAGE_BLOCKS_EXT          = 0x90D8,
        GL_MAX_TESS_EVALUATION_SHADER_STORAGE_BLOCKS_EXT       = 0x90D9,
        GL_PRIMITIVE_RESTART_FOR_PATCHES_SUPPORTED             = 0x8221;

    /** Accepted by the {@code props} parameter of GetProgramResourceiv. */
    public static final int
        GL_IS_PER_PATCH_EXT                         = 0x92E7,
        GL_REFERENCED_BY_TESS_CONTROL_SHADER_EXT    = 0x9307,
        GL_REFERENCED_BY_TESS_EVALUATION_SHADER_EXT = 0x9308;

    /**
     * Accepted by the {@code type} parameter of CreateShader, by the {@code pname} parameter of GetProgramPipelineiv, and returned by the {@code params}
     * parameter of GetShaderiv.
     */
    public static final int
        GL_TESS_EVALUATION_SHADER_EXT = 0x8E87,
        GL_TESS_CONTROL_SHADER_EXT    = 0x8E88;

    /** Accepted by the {@code stages} parameter of UseProgramStages. */
    public static final int
        GL_TESS_CONTROL_SHADER_BIT_EXT    = 0x8,
        GL_TESS_EVALUATION_SHADER_BIT_EXT = 0x10;

    protected EXTTessellationShader() {
        throw new UnsupportedOperationException();
    }

    // --- [ glPatchParameteriEXT ] ---

    public static native void glPatchParameteriEXT(@NativeType("GLenum") int pname, @NativeType("GLint") int value);

}