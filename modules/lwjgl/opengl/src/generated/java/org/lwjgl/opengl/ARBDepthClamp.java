/*
 * Copyright LWJGL. All rights reserved.
 * License terms: https://www.lwjgl.org/license
 * MACHINE GENERATED FILE, DO NOT EDIT
 */
package org.lwjgl.opengl;

/**
 * Native bindings to the <a href="https://www.khronos.org/registry/OpenGL/extensions/ARB/ARB_depth_clamp.txt">ARB_depth_clamp</a> extension.
 * 
 * <p>Conventional OpenGL clips geometric primitives to a clip volume with six faces, two of which are the near and far clip planes. Clipping to the near and
 * far planes of the clip volume ensures that interpolated depth values (after the depth range transform) must be in the [0,1] range.</p>
 * 
 * <p>In some rendering applications such as shadow volumes, it is useful to allow line and polygon primitives to be rasterized without clipping the primitive
 * to the near or far clip volume planes (side clip volume planes clip normally). Without the near and far clip planes, rasterization (pixel coverage
 * determination) in X and Y can proceed normally if we ignore the near and far clip planes. The one major issue is that fragments of a  primitive may
 * extend beyond the conventional window space depth range for depth values (typically the range [0,1]). Rather than discarding fragments that defy the
 * window space depth range (effectively what near and far plane clipping accomplish), the depth values can be clamped to the current depth range.</p>
 * 
 * <p>This extension provides exactly such functionality. This functionality is useful to obviate the need for near plane capping of stenciled shadow volumes.
 * The functionality may also be useful for rendering geometry "beyond" the far plane if an alternative algorithm (rather than depth testing) for hidden
 * surface removal is applied to such geometry (specifically, the painter's algorithm). Similar situations at the near clip plane can be avoided at the
 * near clip plane where apparently solid objects can be "seen through" if they intersect the near clip plane.</p>
 * 
 * <p>Promoted to core in {@link GL32 OpenGL 3.2}.</p>
 */
public final class ARBDepthClamp {

    /**
     * Accepted by the {@code cap} parameter of Enable, Disable, and IsEnabled, and by the {@code pname} parameter of GetBooleanv, GetIntegerv, GetFloatv, and
     * GetDoublev.
     */
    public static final int GL_DEPTH_CLAMP = 0x864F;

    private ARBDepthClamp() {}

}