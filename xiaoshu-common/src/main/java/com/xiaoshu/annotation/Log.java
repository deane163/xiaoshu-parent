package com.xiaoshu.annotation;

import static java.lang.annotation.ElementType.METHOD;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Target;

import com.xiaoshu.enums.LogType;


@Documented
@Inherited
@Target({METHOD})
public @interface Log {

	/**
	 * 操作说明
	 * @return
	 */
	String value() default "";
	
	/**
	 * 操作类型说明
	 * @return
	 */
	LogType type() default  LogType.NULL;
	
}
