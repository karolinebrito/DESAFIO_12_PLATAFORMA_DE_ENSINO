package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Lesson;
import entities.Task;
import entities.Video;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Quantas aulas tem o curso? ");
		int n = sc.nextInt();
		
		List<Lesson> list = new ArrayList<>();
		
		for (int i=0; i<n; i++) {
			System.out.println("Dados da " + (i+1) + "a aula:");
			System.out.print("Conteúdo ou tarefa (c/t)? ");
			char type = sc.next().charAt(0);
			System.out.print("Título: ");
			String title = sc.nextLine();
			sc.nextLine();
			if (type=='c') {
				System.out.print("URL do vídeo: ");
				String url = sc.next();
				System.out.print("Duração em segundos: ");
				int seconds = sc.nextInt();
				Lesson lesson = new Video(title, url, seconds);
				list.add(lesson);
			}
			else {
				System.out.print("Descrição: ");
				String description = sc.nextLine();
				System.out.print("Quantidade de questões: ");
				int questionCount = sc.nextInt();
				Lesson lesson = new Task(title, description, questionCount);
				list.add(lesson);
			}
		}
		System.out.println();
		
		int sum = 0;
		for (Lesson lesson : list) {
			sum += lesson.duration();
		}
		System.out.println("DURAÇÃO TOTAL DO CURSO = " + sum + " segundos");
		sc.close();

	}

}
