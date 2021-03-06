/*
 * Copyright 2017 MovingBlocks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.terasology.sample.nui;

import com.google.common.collect.Iterables;
import org.terasology.entitySystem.entity.EntityManager;
import org.terasology.registry.In;
import org.terasology.rendering.nui.CoreScreenLayer;
import org.terasology.rendering.nui.widgets.UIButton;
import org.terasology.rendering.nui.widgets.UIText;

public class AmountofEntities extends CoreScreenLayer {
    private UIText infoArea;
    private UIButton updateInfoButton;
    private Iterable iter;
    private int n;

    @In
    private EntityManager entityManager;

    @Override
    public void initialise() {
        infoArea = find("infoArea", UIText.class);
        updateInfoButton = find("updateInfoButton", UIButton.class);
        iter = entityManager.getAllEntities();
        n = Iterables.size(iter);

        if (updateInfoButton != null) {
            updateInfoButton.subscribe(button -> {
                infoArea.setText("Total Entities= " + Integer.toString(n));
            });
        }
    }

}

