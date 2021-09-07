package com.hengnan.test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.core.ResolvableType;
import org.springframework.core.env.Environment;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

/**
 * @description:
 * @author: leozhu
 * @create: 2021/2/1 17:26
 **/
public class Test {

    public volatile int inc = 0;

    public void increase() {
        inc++;
    }

    static class TimerThread extends Thread {
        @Override
        public void run() {
            while (true) {
                System.out.println(new Date());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        //创建spring容器
        ApplicationContext applicationContext = new ApplicationContext() {
            @Override
            public String getId() {
                return null;
            }

            @Override
            public String getApplicationName() {
                return null;
            }

            @Override
            public String getDisplayName() {
                return null;
            }

            @Override
            public long getStartupDate() {
                return 0;
            }

            @Override
            public ApplicationContext getParent() {
                return null;
            }

            @Override
            public AutowireCapableBeanFactory getAutowireCapableBeanFactory() throws IllegalStateException {
                return null;
            }

            @Override
            public BeanFactory getParentBeanFactory() {
                return null;
            }

            @Override
            public boolean containsLocalBean(String s) {
                return false;
            }

            @Override
            public boolean containsBeanDefinition(String s) {
                return false;
            }

            @Override
            public int getBeanDefinitionCount() {
                return 0;
            }

            @Override
            public String[] getBeanDefinitionNames() {
                return new String[0];
            }

            @Override
            public <T> ObjectProvider<T> getBeanProvider(Class<T> aClass, boolean b) {
                return null;
            }

            @Override
            public <T> ObjectProvider<T> getBeanProvider(ResolvableType resolvableType, boolean b) {
                return null;
            }

            @Override
            public String[] getBeanNamesForType(ResolvableType resolvableType) {
                return new String[0];
            }

            @Override
            public String[] getBeanNamesForType(ResolvableType resolvableType, boolean b, boolean b1) {
                return new String[0];
            }

            @Override
            public String[] getBeanNamesForType(Class<?> aClass) {
                return new String[0];
            }

            @Override
            public String[] getBeanNamesForType(Class<?> aClass, boolean b, boolean b1) {
                return new String[0];
            }

            @Override
            public <T> Map<String, T> getBeansOfType(Class<T> aClass) throws BeansException {
                return null;
            }

            @Override
            public <T> Map<String, T> getBeansOfType(Class<T> aClass, boolean b, boolean b1) throws BeansException {
                return null;
            }

            @Override
            public String[] getBeanNamesForAnnotation(Class<? extends Annotation> aClass) {
                return new String[0];
            }

            @Override
            public Map<String, Object> getBeansWithAnnotation(Class<? extends Annotation> aClass) throws BeansException {
                return null;
            }

            @Override
            public <A extends Annotation> A findAnnotationOnBean(String s, Class<A> aClass) throws NoSuchBeanDefinitionException {
                return null;
            }

            @Override
            public Object getBean(String s) throws BeansException {
                return null;
            }

            @Override
            public <T> T getBean(String s, Class<T> aClass) throws BeansException {
                return null;
            }

            @Override
            public Object getBean(String s, Object... objects) throws BeansException {
                return null;
            }

            @Override
            public <T> T getBean(Class<T> aClass) throws BeansException {
                return null;
            }

            @Override
            public <T> T getBean(Class<T> aClass, Object... objects) throws BeansException {
                return null;
            }

            @Override
            public <T> ObjectProvider<T> getBeanProvider(Class<T> aClass) {
                return null;
            }

            @Override
            public <T> ObjectProvider<T> getBeanProvider(ResolvableType resolvableType) {
                return null;
            }

            @Override
            public boolean containsBean(String s) {
                return false;
            }

            @Override
            public boolean isSingleton(String s) throws NoSuchBeanDefinitionException {
                return false;
            }

            @Override
            public boolean isPrototype(String s) throws NoSuchBeanDefinitionException {
                return false;
            }

            @Override
            public boolean isTypeMatch(String s, ResolvableType resolvableType) throws NoSuchBeanDefinitionException {
                return false;
            }

            @Override
            public boolean isTypeMatch(String s, Class<?> aClass) throws NoSuchBeanDefinitionException {
                return false;
            }

            @Override
            public Class<?> getType(String s) throws NoSuchBeanDefinitionException {
                return null;
            }

            @Override
            public Class<?> getType(String s, boolean b) throws NoSuchBeanDefinitionException {
                return null;
            }

            @Override
            public String[] getAliases(String s) {
                return new String[0];
            }

            @Override
            public void publishEvent(Object o) {

            }

            @Override
            public String getMessage(String s, Object[] objects, String s1, Locale locale) {
                return null;
            }

            @Override
            public String getMessage(String s, Object[] objects, Locale locale) throws NoSuchMessageException {
                return null;
            }

            @Override
            public String getMessage(MessageSourceResolvable messageSourceResolvable, Locale locale) throws NoSuchMessageException {
                return null;
            }

            @Override
            public Environment getEnvironment() {
                return null;
            }

            @Override
            public org.springframework.core.io.Resource[] getResources(String s) throws IOException {
                return new org.springframework.core.io.Resource[0];
            }

            @Override
            public org.springframework.core.io.Resource getResource(String s) {
                return null;
            }

            @Override
            public ClassLoader getClassLoader() {
                return null;
            }
        };
        EmailEvent ele=new EmailEvent("test","spring_test@163.com","this is a test");
        //发布容器事件
        applicationContext.publishEvent(ele);


//        ctx.publishEvent(ele);

//        String permission = "00000000-00000001,00000000-00000001-10010000,00000000-00000001-10010000-50003636,00000000-00000001-10010000-50003637,00000000-00000001-10010000-50007037";
//        String dataPermission = "00000000-00000001,00000000-00000001-10010000";
//        List<String> sharePermissions = Arrays.asList(permission.split(","));
//        List<String> dataPermissions = Arrays.asList(dataPermission.split(","));
//        List<String> filterPermissions = sharePermissions.stream().filter(it -> !dataPermissions.contains(it)).distinct().collect(Collectors.toList());
//        System.out.println(filterPermissions);


//        List<String> list = new ArrayList<>();
//        list.add("19:40");
//        list.add("08:45");
//        list.add("12:30");
//        list.add("12:10");
//        list.add("06:48");
//        list.add("08:20");
//        List<String> sortList = list.stream().sorted(Comparator.comparing(Objects::toString)).collect(Collectors.toList());
//        System.out.println(sortList);
    }

}
