/*
 * Copyright © Contributing Authors
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
 *
 * Additional copyright and licensing notices may apply for content that was
 * included from other projects. For more information, see ATTRIBUTION.md.
 */

package io.vram.frex.api.renderer;

import java.util.function.BooleanSupplier;

import net.minecraft.resources.ResourceLocation;

import io.vram.frex.api.material.MaterialCondition;

/**
 * Interface for rendering plug-ins that provide enhanced capabilities
 * for model lighting, buffering and rendering. Such plug-ins implement the
 * enhanced model rendering interfaces specified by the Fabric API.
 */
public interface ConditionManager {
	MaterialCondition createCondition(BooleanSupplier supplier, boolean affectBlocks, boolean affectItems);

	int indexOf(MaterialCondition condition);

	MaterialCondition conditionFromIndex(int index);

	boolean registerCondition(ResourceLocation id, MaterialCondition condition);

	MaterialCondition conditionFromId(ResourceLocation id);

	MaterialCondition alwaysTrue();
}
