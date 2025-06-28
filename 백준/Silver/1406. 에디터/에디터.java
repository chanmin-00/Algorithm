

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	private static class Node {

		char data; // 현재 노드의 문자 정보
		Node next; // 다음 노드 정보
		Node prev; // 이전 노드 정보

		Node(char data) {
			this.data = data;
			this.next = null;
			this.prev = null;
		}

		public void setNext(Node nextNode) {
			this.next = nextNode;
		}

		public void setPrev(Node prevNode) {
			this.prev = prevNode;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // 표준 입력
		String init = reader.readLine(); // 초기 문자열
		int cnt = Integer.parseInt(reader.readLine()); // 입력할 명령어의 개수

		Node head = new Node('0'); // 더미 시작 노드
		Node cursor = head; // 커서는 현재 위치 정보를 저장하고 있음

		for (int i = 0; i < init.length(); i++) {
			Node newNode = new Node(init.charAt(i));
			cursor.setNext(newNode);
			newNode.setPrev(cursor);
			cursor = newNode;
		}

		for (int i = 0; i < cnt; i++) {
			String command = reader.readLine();

			if (command.equals("L") && cursor.prev != null) // 커서를 왼쪽으로 한 칸 옮김
			{
				cursor = cursor.prev;
			} else if (command.equals("D") && cursor.next != null) // 커서를 오른쪽으로 한 칸 옮김
			{
				cursor = cursor.next;
			} else if (command.equals("B") && cursor.prev != null)// 커서 왼쪽의 문자를 삭제
			{
				Node tmpNode = cursor;
				if (cursor != head) {
					cursor = cursor.prev;
					cursor.setNext(tmpNode.next);
					if (tmpNode.next != null) {
						tmpNode.next.setPrev(cursor);
					}
				}
			} else if (command.startsWith("P")) { // 문자를 커서 왼쪽에 추가함
				Node newNode = new Node(command.charAt(2));
				Node nextNode = cursor.next;

				cursor.setNext(newNode);
				newNode.setPrev(cursor);
				newNode.setNext(nextNode);

				if (nextNode != null)
					nextNode.setPrev(newNode);

				cursor = newNode;
			}
		}

		Node iterator = head.next;
		StringBuilder sb = new StringBuilder();

		while (iterator != null) {
			sb.append(iterator.data);
			iterator = iterator.next;
		}

		System.out.println(sb);
	}
}

