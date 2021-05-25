/**
 * 
 */
package com.practise.abstractdemo;

/**
 * @author Dell
 *
 */
public class DemoAccess extends DemoAbstract{

	public String testaccess() {
		return "Access Demo";
	}

	@Override
	public String testabstract() {
		return "Child class implementation of Parent.";
	}
}
