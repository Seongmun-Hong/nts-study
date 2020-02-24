package javatest;

import java.util.List;
import java.util.Optional;

public class Main {
	public static void main(String[] args) {
		String a = null;
		String str = "abc";
		System.out.println(methods(str));

		List<Integer> arr = null;
		System.out.println(calculateAverageScore(arr));
	}

	public static String methods(String input) {
		Optional<String> inputOptional = Optional.ofNullable(input);
		inputOptional.orElseThrow(() -> new IllegalArgumentException());
		return input + "1";
	}

	public static double calculateAverageScore(List<Integer> comments) {
		long averageScore = comments.stream().count();

		return Math.round(averageScore * 10) / 10;
	}

}
