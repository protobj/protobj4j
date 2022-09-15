package io.protobj.util;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

public class ObjectEquals {

    public static boolean compareObject(Object bean1, Object bean2) {
        if (bean1 == null) {
            System.out.println("bean1 null  cant compare");
            return false;
        }
        if (bean2 == null) {
            System.out.println("bean2 null  cant compare");
            return false;
        }
        Class<?> oldClass = bean1.getClass();
        Class<?> newClass = bean2.getClass();

        if (oldClass != newClass) {
            System.out.println("class not equals");
            return false;
        }
        if (canUseObjectsEquals(oldClass)) {
            return Objects.equals(bean1, bean2);
        }
        try {
            Field[] fields = bean1.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (Modifier.isStatic(field.getModifiers())) {
                    continue;
                }
                PropertyDescriptor pd = new PropertyDescriptor(field.getName(), oldClass);
                Method getMethod = pd.getReadMethod();
                Object o1 = getMethod.invoke(bean1);
                Object o2 = getMethod.invoke(bean2);
                boolean equals;
                if (field.getType().isArray()) {
                    equals = arrayCompareEquals(o1, o2);
                } else if (Map.class.isAssignableFrom(field.getType())) {
                    equals = mapCompareEquals(o1, o2);
                } else if (Collection.class.isAssignableFrom(field.getType())) {
                    equals = collectionCompareEquals(field, o1, o2);
                } else {
                    equals = compareObject(o1, o2);
                }
                if (!equals) {
                    String stringBuilder = field.getName() + "%n".formatted() + "old:" + o1 + "%n".formatted() + "new:" + o2 + "%n".formatted();
                    System.out.println(stringBuilder);
                    return false;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    private static boolean collectionCompareEquals(Field field, Object o1, Object o2) {
        if ((o1 == null || ((Collection<?>) o1).size() == 0) && (o2 == null || ((Collection<?>) o2).size() == 0)) {
            return true;
        }
        Collection<?> collection1 = (Collection<?>) o1;
        Collection<?> collection2 = (Collection<?>) o2;
        if (collection1.size() != collection2.size()) {
            return false;
        }
        if (Set.class.isAssignableFrom(field.getType())) {
            return setCompareEquals((Set<?>) o1, (Set<?>) o2);
        } else {
            return collectionCompareEquals(collection1, collection2);
        }
    }

    private static boolean collectionCompareEquals(Collection<?> collection1, Collection<?> collection2) {
        Iterator<?> iterator1 = collection1.iterator();
        Iterator<?> iterator2 = collection2.iterator();
        while (iterator1.hasNext() && iterator2.hasNext()) {
            if (!compareObject(iterator1.next(), iterator2.next())) {
                return false;
            }
        }
        return !iterator1.hasNext() && !iterator2.hasNext();
    }

    private static boolean setCompareEquals(Set<?> set1, Set<?> set2) {
        boolean equals = true;
        for (Object o : set1) {
            if (canUseObjectsEquals(o.getClass())) {
                equals = set2.contains(o);
            } else {
                for (Object o3 : set2) {
                    equals = compareObject(o, o3);
                    if (equals) break;
                }
                if (!equals) {
                    break;
                }
            }
        }
        return equals;
    }

    private static boolean mapCompareEquals(Object o1, Object o2) {
        if ((o1 == null || ((Map<?, ?>) o1).size() == 0) && (o2 == null || ((Map<?, ?>) o2).size() == 0)) {
            return true;
        }
        Map<?, ?> map1 = (Map<?, ?>) o1;
        Map<?, ?> map2 = (Map<?, ?>) o2;
        for (Map.Entry<?, ?> entry : map1.entrySet()) {
            Object o = map2.get(entry.getKey());
            if (canUseObjectsEquals(o.getClass())) {
                if (!Objects.equals(entry.getValue(), o)) {
                    return false;
                }
            } else {
                if (!compareObject(entry.getValue(), o)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean arrayCompareEquals(Object o1, Object o2) {
        boolean equals;
        int oldLen;
        int newLen;
        if ((o1 == null || (oldLen = Array.getLength(o1)) == 0) || (o2 == null || (newLen = Array.getLength(o2)) == 0)) {
            equals = true;
        } else {
            boolean notEquals = false;
            int min = Math.min(oldLen, newLen);
            if (oldLen > min) {
                for (int i = min; i < oldLen; i++) {
                    if (Array.get(o1, i) != null) {
                        notEquals = true;
                        break;
                    }
                }
            } else if (newLen > min) {
                for (int i = min; i < newLen; i++) {
                    if (Array.get(o2, i) != null) {
                        notEquals = true;
                        break;
                    }
                }
            }
            if (!notEquals) {
                for (int i = 0; i < min; i++) {
                    notEquals = !compareObject(Array.get(o1, i), Array.get(o2, i));
                    if (notEquals) {
                        break;
                    }
                }
            }
            equals = !notEquals;
        }
        return equals;
    }

    private static boolean canUseObjectsEquals(Class<?> oldClass) {
        return oldClass.isEnum()//
                || oldClass.isPrimitive()//
                || oldClass == Integer.class //
                || oldClass == Short.class //
                || oldClass == Byte.class//
                || oldClass == Character.class //
                || oldClass == Boolean.class //
                || oldClass == Long.class //
                || oldClass == Float.class //
                || oldClass == Double.class //
                || oldClass == String.class;
    }
}
