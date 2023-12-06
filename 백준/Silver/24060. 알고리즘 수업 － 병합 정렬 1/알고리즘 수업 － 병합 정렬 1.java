import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static int[] temp,arr;
	public static int count = 0;
	public static int K;
	public static int result = -1;
	public static void merge_sort(int[] arr,int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			merge_sort(arr,left,mid);
			merge_sort(arr,mid+1,right);
			merge(arr,left,mid,right);
		}
	}

	public static void merge(int[] arr,int left, int mid, int right) {
		int i = left;
		int j = mid + 1;
		int t = 0;

		while (i < mid + 1 && j <= right) {
			if (arr[i] <= arr[j]) {
				temp[t++] = arr[i++];
			}else {
				temp[t++] = arr[j++];
			}
		}

		while (i <= mid) {
			temp[t++] = arr[i++];
		}

		while (j <= right) {
			temp[t++] = arr[j++];
		}

		i = left;
		t = 0;

		while (i <= right) {
			arr[i++] = temp[t++];
			count++;
			if (count == K) {
				result = arr[i-1];
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		temp = new int[N];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		merge_sort(arr,0,arr.length-1);

		System.out.println(result);
	}

}
