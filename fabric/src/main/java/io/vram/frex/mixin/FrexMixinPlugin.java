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

package io.vram.frex.mixin;

import net.fabricmc.loader.api.FabricLoader;

import io.vram.frex.fabric.compat.SimpleMixinConfig;

public class FrexMixinPlugin extends SimpleMixinConfig {
	public FrexMixinPlugin() {
		super("io.vram.frex.mixin.", c -> {
			if (FabricLoader.getInstance().isModLoaded("fabric-renderer-api-v1")) {
				c.accept("MixinBakedModel");
				c.accept("MixinMultipartBakedModel");
				c.accept("MixinWeightedBakedModel");
			}
		});
	}
}
