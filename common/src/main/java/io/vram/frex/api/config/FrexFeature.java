/*
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not
 *  use this file except in compliance with the License.  You may obtain a copy
 *  of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 *  WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 *  License for the specific language governing permissions and limitations under
 *  the License.
 */

package io.vram.frex.api.config;

import io.vram.frex.impl.config.FrexFeatureImpl;

public interface FrexFeature {
	static boolean isAvailable(int featureId) {
		return FrexFeatureImpl.isAvailable(featureId);
	}

	/**
	 * Renderers should call this exactly once during init to declare available features.
	 *
	 * @param features Array of feature flags declared here or third-party flags declared elsewhere.
	 */
	static void registerFeatures(int... features) {
		FrexFeatureImpl.registerFeatures(features);
	}

	// IDs 0 - 4095 are reserved for FREX.

	/**
	 * Present when registerOrUpdateMaterial is supported.
	 * If not present, materials cannot be changed once registered.
	 * Renderer-dependent, unavailable with Fabric API implementations.
	 */
	int UPDATE_MATERIAL_REGISTRATION = 0;

	/**
	 * Present when renderer uses held item light API.
	 * Renderer-dependent, unavailable with Fabric API implementations.
	 * This feature is also pipeline-dependent.
	 *
	 * <p>Note that JSON loading and the event API are
	 * provided by FREX and will always be available - no
	 * special handling is required to create a soft dependency.
	 */
	int HELD_ITEM_LIGHTS = 1;

	int MATERIAL_SHADERS = 1024;

	/**
	 * Present when the renderer consumes physical texture maps from FREX and
	 * makes them available to shaders to enable physically-based-rendering.
	 */
	int PHYSICAL_TEXTURES = 1025;

	/** Third-party extension features begin numbering here. */
	int EXTENSION_BASE = 4096;
}
