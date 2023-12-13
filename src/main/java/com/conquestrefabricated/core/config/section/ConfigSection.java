package com.conquestrefabricated.core.config.section;

import com.electronwill.nightconfig.core.*;

import java.util.*;
import java.util.function.IntSupplier;
import java.util.function.LongSupplier;
import java.util.function.Supplier;

public interface ConfigSection extends CommentedConfig {

    void save();

    CommentedConfig getRoot();

    List<String> getPath(String path);

    List<String> getPath(List<String> path);

    @Override
    default String setComment(String path, String comment) {
        return getRoot().setComment(getPath(path), comment);
    }

    @Override
    default String setComment(List<String> path, String comment) {
        return getRoot().setComment(getPath(path), comment);
    }

    @Override
    default String removeComment(String path) {
        return getRoot().removeComment(getPath(path));
    }

    @Override
    default String removeComment(List<String> path) {
        return getRoot().removeComment(getPath(path));
    }

    @Override
    default void clearComments() {
        getRoot().clearComments();
    }

    @Override
    default void putAllComments(Map<String, CommentNode> comments) {
        getRoot().putAllComments(comments);
    }

    @Override
    default void putAllComments(UnmodifiableCommentedConfig commentedConfig) {
        getRoot().putAllComments(commentedConfig);
    }

    @Override
    default UnmodifiableCommentedConfig unmodifiable() {
        return getRoot().unmodifiable();
    }

    @Override
    default CommentedConfig checked() {
        return getRoot().checked();
    }

    @Override
    default Map<String, String> commentMap() {
        return getRoot().commentMap();
    }

    @Override
    default Set<? extends com.electronwill.nightconfig.core.CommentedConfig.Entry> entrySet() {
        return getRoot().entrySet();
    }

    @Override
    default CommentedConfig createSubConfig() {
        return getRoot().createSubConfig();
    }

    @Override
    default String getComment(String path) {
        return getRoot().getComment(getPath(path));
    }

    @Override
    default String getComment(List<String> path) {
        return getRoot().getComment(getPath(path));
    }

    @Override
    default Optional<String> getOptionalComment(String path) {
        return getRoot().getOptionalComment(getPath(path));
    }

    @Override
    default Optional<String> getOptionalComment(List<String> path) {
        return getRoot().getOptionalComment(getPath(path));
    }

    @Override
    default boolean containsComment(String path) {
        return getRoot().containsComment(getPath(path));
    }

    @Override
    default boolean containsComment(List<String> path) {
        return getRoot().containsComment(getPath(path));
    }

    @Override
    default Map<String, CommentNode> getComments() {
        return getRoot().getComments();
    }

    @Override
    default void getComments(Map<String, CommentNode> destination) {
        getRoot().getComments(destination);
    }

    default float getAsFloat(String path, double defValue) {
        double value = getOrElse(path, defValue);
        return (float) value;
    }

    @Override
    default <T> T get(String path) {
        return getRoot().get(getPath(path));
    }

    @Override
    default <T> T get(List<String> path) {
        return getRoot().get(getPath(path));
    }

    @Override
    default <T> T getRaw(String path) {
        return getRoot().getRaw(getPath(path));
    }

    @Override
    default <T> T getRaw(List<String> path) {
        return getRoot().getRaw(getPath(path));
    }

    @Override
    default <T> Optional<T> getOptional(String path) {
        return getRoot().getOptional(getPath(path));
    }

    @Override
    default <T> Optional<T> getOptional(List<String> path) {
        return getRoot().getOptional(getPath(path));
    }

    @Override
    default <T> T getOrElse(String path, T defaultValue) {
        return getRoot().getOrElse(getPath(path), defaultValue);
    }

    @Override
    default <T> T getOrElse(List<String> path, T defaultValue) {
        return getRoot().getOrElse(getPath(path), defaultValue);
    }

    @Override
    default <T> T getOrElse(List<String> path, Supplier<T> defaultValueSupplier) {
        return getRoot().getOrElse(getPath(path), defaultValueSupplier);
    }

    @Override
    default <T> T getOrElse(String path, Supplier<T> defaultValueSupplier) {
        return getRoot().getOrElse(getPath(path), defaultValueSupplier);
    }

    @Override
    default <T extends Enum<T>> T getEnum(String path, Class<T> enumType, EnumGetMethod method) {
        return getRoot().getEnum(getPath(path), enumType, method);
    }

    @Override
    default <T extends Enum<T>> T getEnum(String path, Class<T> enumType) {
        return getRoot().getEnum(getPath(path), enumType);
    }

    @Override
    default <T extends Enum<T>> T getEnum(List<String> path, Class<T> enumType, EnumGetMethod method) {
        return getRoot().getEnum(getPath(path), enumType, method);
    }

    @Override
    default <T extends Enum<T>> T getEnum(List<String> path, Class<T> enumType) {
        return getRoot().getEnum(getPath(path), enumType);
    }

    @Override
    default <T extends Enum<T>> Optional<T> getOptionalEnum(String path, Class<T> enumType, EnumGetMethod method) {
        return getRoot().getOptionalEnum(getPath(path), enumType, method);
    }

    @Override
    default <T extends Enum<T>> Optional<T> getOptionalEnum(String path, Class<T> enumType) {
        return getRoot().getOptionalEnum(getPath(path), enumType);
    }

    @Override
    default <T extends Enum<T>> Optional<T> getOptionalEnum(List<String> path, Class<T> enumType, EnumGetMethod method) {
        return getRoot().getOptionalEnum(getPath(path), enumType, method);
    }

    @Override
    default <T extends Enum<T>> Optional<T> getOptionalEnum(List<String> path, Class<T> enumType) {
        return getRoot().getOptionalEnum(getPath(path), enumType);
    }

    @Override
    default <T extends Enum<T>> T getEnumOrElse(String path, T defaultValue, EnumGetMethod method) {
        return getRoot().getEnumOrElse(getPath(path), defaultValue, method);
    }

    @Override
    default <T extends Enum<T>> T getEnumOrElse(String path, T defaultValue) {
        return getRoot().getEnumOrElse(getPath(path), defaultValue);
    }

    @Override
    default <T extends Enum<T>> T getEnumOrElse(List<String> path, T defaultValue, EnumGetMethod method) {
        return getRoot().getEnumOrElse(getPath(path), defaultValue, method);
    }

    @Override
    default <T extends Enum<T>> T getEnumOrElse(List<String> path, T defaultValue) {
        return getRoot().getEnumOrElse(getPath(path), defaultValue);
    }

    @Override
    default <T extends Enum<T>> T getEnumOrElse(String path, Class<T> enumType, EnumGetMethod method, Supplier<T> defaultValueSupplier) {
        return getRoot().getEnumOrElse(getPath(path), enumType, method, defaultValueSupplier);
    }

    @Override
    default <T extends Enum<T>> T getEnumOrElse(String path, Class<T> enumType, Supplier<T> defaultValueSupplier) {
        return getRoot().getEnumOrElse(getPath(path), enumType, defaultValueSupplier);
    }

    @Override
    default <T extends Enum<T>> T getEnumOrElse(List<String> path, Class<T> enumType, EnumGetMethod method, Supplier<T> defaultValueSupplier) {
        return getRoot().getEnumOrElse(getPath(path), enumType, method, defaultValueSupplier);
    }

    @Override
    default <T extends Enum<T>> T getEnumOrElse(List<String> path, Class<T> enumType, Supplier<T> defaultValueSupplier) {
        return getRoot().getEnumOrElse(getPath(path), enumType, defaultValueSupplier);
    }

    @Override
    default int getInt(String path) {
        return getRoot().getInt(getPath(path));
    }

    @Override
    default int getInt(List<String> path) {
        return getRoot().getInt(getPath(path));
    }

    @Override
    default OptionalInt getOptionalInt(String path) {
        return getRoot().getOptionalInt(getPath(path));
    }

    @Override
    default OptionalInt getOptionalInt(List<String> path) {
        return getRoot().getOptionalInt(getPath(path));
    }

    @Override
    default int getIntOrElse(String path, int defaultValue) {
        return getRoot().getIntOrElse(getPath(path), defaultValue);
    }

    @Override
    default int getIntOrElse(List<String> path, int defaultValue) {
        return getRoot().getIntOrElse(getPath(path), defaultValue);
    }

    @Override
    default int getIntOrElse(String path, IntSupplier defaultValueSupplier) {
        return getRoot().getIntOrElse(getPath(path), defaultValueSupplier);
    }

    @Override
    default int getIntOrElse(List<String> path, IntSupplier defaultValueSupplier) {
        return getRoot().getIntOrElse(getPath(path), defaultValueSupplier);
    }

    @Override
    default long getLong(String path) {
        return getRoot().getLong(getPath(path));
    }

    @Override
    default long getLong(List<String> path) {
        return getRoot().getLong(getPath(path));
    }

    @Override
    default OptionalLong getOptionalLong(String path) {
        return getRoot().getOptionalLong(getPath(path));
    }

    @Override
    default OptionalLong getOptionalLong(List<String> path) {
        return getRoot().getOptionalLong(getPath(path));
    }

    @Override
    default long getLongOrElse(String path, long defaultValue) {
        return getRoot().getLongOrElse(getPath(path), defaultValue);
    }

    @Override
    default long getLongOrElse(List<String> path, long defaultValue) {
        return getRoot().getLongOrElse(getPath(path), defaultValue);
    }

    @Override
    default long getLongOrElse(String path, LongSupplier defaultValueSupplier) {
        return getRoot().getLongOrElse(getPath(path), defaultValueSupplier);
    }

    @Override
    default long getLongOrElse(List<String> path, LongSupplier defaultValueSupplier) {
        return getRoot().getLongOrElse(getPath(path), defaultValueSupplier);
    }

    @Override
    default byte getByte(String path) {
        return getRoot().getByte(getPath(path));
    }

    @Override
    default byte getByte(List<String> path) {
        return getRoot().getByte(getPath(path));
    }

    @Override
    default byte getByteOrElse(String path, byte defaultValue) {
        return getRoot().getByteOrElse(getPath(path), defaultValue);
    }

    @Override
    default byte getByteOrElse(List<String> path, byte defaultValue) {
        return getRoot().getByteOrElse(getPath(path), defaultValue);
    }

    @Override
    default short getShort(String path) {
        return getRoot().getShort(getPath(path));
    }

    @Override
    default short getShort(List<String> path) {
        return getRoot().getShort(getPath(path));
    }

    @Override
    default short getShortOrElse(String path, short defaultValue) {
        return getRoot().getShortOrElse(getPath(path), defaultValue);
    }

    @Override
    default short getShortOrElse(List<String> path, short defaultValue) {
        return getRoot().getShortOrElse(getPath(path), defaultValue);
    }

    @Override
    default char getChar(String path) {
        return getRoot().getChar(getPath(path));
    }

    @Override
    default char getChar(List<String> path) {
        return getRoot().getChar(getPath(path));
    }

    @Override
    default char getCharOrElse(String path, char defaultValue) {
        return getRoot().getCharOrElse(getPath(path), defaultValue);
    }

    @Override
    default char getCharOrElse(List<String> path, char defaultValue) {
        return getRoot().getCharOrElse(getPath(path), defaultValue);
    }

    @Override
    default boolean contains(String path) {
        return getRoot().contains(getPath(path));
    }

    @Override
    default boolean contains(List<String> path) {
        return getRoot().contains(getPath(path));
    }

    @Override
    default boolean isNull(String path) {
        return getRoot().isNull(getPath(path));
    }

    @Override
    default boolean isNull(List<String> path) {
        return getRoot().isNull(getPath(path));
    }

    @Override
    default int size() {
        return getRoot().size();
    }

    @Override
    default boolean isEmpty() {
        return getRoot().isEmpty();
    }

    @Override
    default Map<String, Object> valueMap() {
        return getRoot().valueMap();
    }

    @Override
    default ConfigFormat<?> configFormat() {
        return getRoot().configFormat();
    }

    @Override
    default <T> T apply(String path) {
        return getRoot().apply(getPath(path));
    }

    @Override
    default <T> T apply(List<String> path) {
        return getRoot().apply(getPath(path));
    }

    @Override
    default <T> T set(String path, Object value) {
        return getRoot().set(getPath(path), value);
    }

    @Override
    default <T> T set(List<String> path, Object value) {
        return getRoot().set(getPath(path), value);
    }

    @Override
    default boolean add(List<String> path, Object value) {
        return getRoot().add(getPath(path), value);
    }

    @Override
    default boolean add(String path, Object value) {
        return getRoot().add(getPath(path), value);
    }

    @Override
    default void addAll(UnmodifiableConfig config) {
        getRoot().addAll(config);
    }

    @Override
    default void putAll(UnmodifiableConfig config) {
        getRoot().putAll(config);
    }

    @Override
    default <T> T remove(String path) {
        return getRoot().remove(getPath(path));
    }

    @Override
    default <T> T remove(List<String> path) {
        return getRoot().remove(getPath(path));
    }

    @Override
    default void removeAll(UnmodifiableConfig config) {
        getRoot().removeAll(config);
    }

    @Override
    default void clear() {
        getRoot().clear();
    }

    @Override
    default void update(String path, Object value) {
        getRoot().update(getPath(path), value);
    }

    @Override
    default void update(List<String> path, Object value) {
        getRoot().update(getPath(path), value);
    }
}
