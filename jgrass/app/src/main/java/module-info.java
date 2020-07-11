/**
 * 
 */
/**
 * @author Pankaj Bhushan
 *
 */
module com.grassproject.jgrass.app {
	requires spring.boot.autoconfigure;
	requires spring.boot;
	requires spring.beans;
	requires spring.context;
	requires spring.web;
	requires spring.webmvc;
	requires org.apache.tomcat.embed.core;
	requires log4j;
	requires org.apache.bcel;
	
	exports com.grassproject.jgrass;
}