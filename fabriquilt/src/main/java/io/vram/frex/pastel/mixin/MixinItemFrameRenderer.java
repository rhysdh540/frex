/*
 * This file is part of FREX and is licensed to the project under
 * terms that are compatible with the GNU Lesser General Public License.
 * See the NOTICE file distributed with this work for additional information
 * regarding copyright ownership and licensing.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package io.vram.frex.pastel.mixin;

import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.ModelBlockRenderer;
import net.minecraft.client.renderer.entity.ItemFrameRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.world.entity.decoration.ItemFrame;
import net.minecraft.world.level.block.state.BlockState;

import io.vram.frex.pastel.PastelEntityBlockRenderContext;

/**
 * Handles rendering of the item frame itself, enabling material transformation
 * and other material-dependent features.
 */
@Mixin(ItemFrameRenderer.class)
public abstract class MixinItemFrameRenderer {
	@Redirect(method = "render(Lnet/minecraft/world/entity/decoration/ItemFrame;FFLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;I)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/block/ModelBlockRenderer;renderModel(Lcom/mojang/blaze3d/vertex/PoseStack$Pose;Lcom/mojang/blaze3d/vertex/VertexConsumer;Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/client/resources/model/BakedModel;FFFII)V"))
	private void onRender(
		// these are the redirect params
		ModelBlockRenderer renderer,
		PoseStack.Pose entry,
		VertexConsumer vertexConsumer,
		@Nullable BlockState blockState,
		BakedModel bakedModel,
		float green, float red, float blue, int light, int overlay,
		// these are the locals
		ItemFrame itemFrameEntity,
		float f, float g, PoseStack matrixStack, MultiBufferSource vertexConsumerProvider, int i
	) {
		PastelEntityBlockRenderContext.get().renderItemFrame(renderer, bakedModel, matrixStack, vertexConsumerProvider, OverlayTexture.NO_OVERLAY, light, itemFrameEntity);
	}
}
