package com.conquestrefabricated.api.painting.art;

import java.util.List;

/**
 * @author dags <dags@dags.me>
 */
public interface Art<T> {

    String DATA_TAG = "Painting";
    String TYPE_TAG = "TypeID";
    String ART_TAG = "ArtID";

    int u();

    int v();

    int width();

    int height();

    int textureWidth();

    int textureHeight();

    T getReference();

    String getName();

    String getDisplayName(String parent);

    List<Art<T>> getAll();

    ArtRenderer getRenderer();

    static <T> Art<T> find(T art, List<Art<T>> list) {
        for (Art<T> a : list) {
            if (a.getReference() == art) {
                return a;
            }
        }
        return null;
    }
}
