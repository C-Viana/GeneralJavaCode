package lib;

import java.util.List;

import lombok.NonNull;

public class ArrayHandler {
	
	@SuppressWarnings("unchecked")
	<T> T[] convertListToArray(@NonNull Class<T> type, List<?> list) {
		if(list == null) throw new NullPointerException("Argument \"list\" is null and cannot be converted!");
		
		if( type == Integer.class ) {
			return (T[]) list.toArray(Integer[]::new);
		}
		else if( type == Double.class ) {
			return (T[]) list.toArray(Double[]::new);
		}
		else if( type == Float.class ) {
			return (T[]) list.toArray(Float[]::new);
		}
		else if( type == String.class ) {
			return (T[]) list.toArray(String[]::new);
		}
		else {
			return (T[]) list.toArray(Object[]::new);
		}
	}
	
	<T extends Number> void bubbleSortNumbersAsc( T[] arrayList ) {
		T aux;
		for (int i = 0; i < arrayList.length; i++) {
			for (int j = 0; j < arrayList.length-1; j++) {
				if( arrayList[j].doubleValue() > arrayList[i].doubleValue() ) {
					aux = arrayList[i];
					arrayList[i] = arrayList[j];
					arrayList[j] = aux;
				}
			}
		}
	}
	
	<T extends Number> void selectionSortNumbersAsc( T[] arrayList ) {
		T minValue = null;
		int index = 0;
		
		for (int i = 0; i < arrayList.length; i++) {
			minValue = arrayList[i];
			for (int j = i+1; j < arrayList.length; j++) {
				if(arrayList[j].doubleValue() < minValue.doubleValue()) {
					index = j;
					minValue = arrayList[j];
				}
			}
			if( arrayList[i].doubleValue() > minValue.doubleValue() ) {
				arrayList[index] = arrayList[i];
				arrayList[i] = minValue;
			}
		}
	}
	
	<T extends Number> void quickSortNumbersAsc(T[] arrayList, int left, int right) {
		T pivot = null;
		T aux = null;
		int index = left+1;

		if( left < right ) {
			pivot = arrayList[left];
			for (int i = index; i < right; i++) {
				if(arrayList[i].doubleValue() <= pivot.doubleValue()) {
					aux = arrayList[i];
					arrayList[i] = arrayList[index];
					arrayList[index] = aux;
					index++;
				}
			}
			index--;
			aux = arrayList[index];
			arrayList[index] = pivot;
			arrayList[left] = aux;
			
			quickSortNumbersAsc(arrayList, left, index);
			quickSortNumbersAsc(arrayList, index+1, right);
		}
	}
	
	<T extends Number> void mergeSortNumbersAsc(T[] arrayList, int first, int last) {
		int mid = (first+last)/2;
		T aux;
		if(first < last) {
			mergeSortNumbersAsc(arrayList, first, mid);
			mergeSortNumbersAsc(arrayList, mid+1, last);
		}
		for (int i = 0; i < last-1; i++) {
			if(arrayList[i].doubleValue() > arrayList[i+1].doubleValue()) {
				aux = arrayList[i];
				arrayList[i] = arrayList[i+1];
				arrayList[i+1] = aux;
			}
		}
	}
	
	<T extends Number> void insertionSortNumbersAsc(T[] arrayList) {
		T aux = null;
		for (int i = 0; i < arrayList.length-1; i++) {
			if(arrayList[i].doubleValue() > arrayList[i+1].doubleValue()) {
				int index = i;
				while(arrayList[index+1].doubleValue() < arrayList[index].doubleValue()) {
					aux = arrayList[index];
					arrayList[index] = arrayList[index+1];
					arrayList[index+1] = aux;
					if(index > 0) index--;
				}
			}
		}
	}
	
}
