import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        //Tạo 1 đối tượng Class từ tên
        Class<?> aClass = Class.forName("entities.Cat");

        getSimpleInforOfClass(aClass);

    }
    public static void getSimpleInforOfClass(Class<?> aClass){
        //Lấy thông tin tên
        System.out.println("TÊN CLASS");
        System.out.println("Class name : " + aClass.getName());
        System.out.println("Simple class name: " + aClass.getSimpleName());
        System.out.println("==============================================\n");

        //Lấy thông tin package nơi đặt class
        System.out.println("TÊN PACKAGE NƠI ĐẶT CLASS");
        Package aPackage = aClass.getPackage();
        System.out.println("Package name : " + aPackage.getName());
        System.out.println("==============================================\n");

        //Lấy kiểu của class: Public, interface, final, abstract
        System.out.println("MODIFIERS CỦA CLAZZ");
        int modifiers = aClass.getModifiers();
        System.out.println("Modifiers : " + modifiers);
        boolean isPublic = Modifier.isPublic(modifiers);
        boolean isInterface = Modifier.isInterface(modifiers);
        boolean isAbstract = Modifier.isAbstract(modifiers);
        boolean isFinal = Modifier.isFinal(modifiers);
        System.out.println("Is Public? " + isPublic);
        System.out.println("Is Final? " + isFinal);
        System.out.println("Is Interface? " + isInterface);
        System.out.println("Is Abstract? " + isAbstract);
        System.out.println("==============================================\n");

        //Lấy thông tin class cha
        System.out.println("CLASS CHA");
        Class<?> aSuperClass = aClass.getSuperclass();
        System.out.println("Super class: " + aSuperClass.getSimpleName());
        System.out.println("==============================================\n");

        //Lấy thông tin các interface mà class triển khai
        System.out.println("INTERFACE MÀ CLASS TRIỂN KHAI");
        Class<?>[] iClass = aClass.getInterfaces();
        for (Class<?> i : iClass) {
            System.out.println("Super interface: " + i.getSimpleName());
        }
        System.out.println("==============================================\n");

        //Lấy thông tin các hàm tạo
        System.out.println("CÁC HÀM TẠO");
        Constructor<?>[] constructors = aClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println("Constructor: " + constructor.getName() + " has " + constructor.getParameterCount() + " params : ");
            Class<?>[] paramType = constructor.getParameterTypes();
            for (Class<?> param : paramType)
                System.out.println("\t" + param.getName());
        }
        System.out.println("==============================================\n");

        //Lấy thông tin các method được định nghĩa, kể cả các method của lớp cha
        System.out.println("CÁC PUBILC METHOD (KỂ CẢ METHOD CỦA CLASS CHA)");
        Method[] methods = aClass.getDeclaredMethods();
        for(Method method: methods){
            System.out.println("Method:" + method.getName());
        }
        System.out.println("==============================================\n");

        //Lấy thông tin các trường public kể cả các trường của class cha
        System.out.println("CÁC PUBLIC FILED (KỂ CẢ FIELD CỦA CLAZZ CHA");
        Field[] fields = aClass.getFields();
        for(Field field: fields){
            System.out.println("Filed :" + field.getName());
        }
        System.out.println("==============================================\n");

        //Lấy thông tin các Anntation đặt trên class
        System.out.println("CÁC ANNOTATION ĐẶT TRÊN CLAZZ");
        Annotation[] annotations = aClass.getAnnotations();
        for(Annotation annotation: annotations){
            System.out.println("Annotation: "+ annotation.annotationType().getSimpleName());
        }
        System.out.println("==============================================\n");
    }
}