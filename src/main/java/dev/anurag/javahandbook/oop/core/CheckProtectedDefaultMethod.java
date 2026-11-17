package dev.anurag.javahandbook.oop.core;

public class CheckProtectedDefaultMethod extends DefaultMethod{
	@Override
	void defaultMethodAccesibility() {
		System.out.println("Calling from main class CheckProtectedDefaultMethod");
		super.defaultMethodAccesibility();
	}

}
