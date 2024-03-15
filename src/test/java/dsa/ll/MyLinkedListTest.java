package dsa.ll;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class MyLinkedListTest {

    @Test
    void findMiddleNodeImpair() {
        MyLinkedList myLinkedList = getMyLinkedList();

        assertThat(myLinkedList.findMiddleNode().value).isEqualTo(3);
    }

    @Test
    void findMiddleNodePair() {
        MyLinkedList myLinkedList = getMyLinkedList();
        myLinkedList.append(6);

        assertThat(myLinkedList.findMiddleNode().value).isEqualTo(4);
    }

    @Test
    void simpleListHasNoLoop() {
        MyLinkedList myLinkedList = getMyLinkedList();
        assertThat(myLinkedList.hasLoop()).isFalse();
    }

    @Test
    void loopedListHasLoop() {
        MyLinkedList myLinkedList = getMyLinkedList();

        // create a loop by connecting the tail to the second node
        myLinkedList.getTail().next = myLinkedList.getHead().next;
        assertThat(myLinkedList.hasLoop()).isTrue();
    }

    @Test
    void removeDuplicatesTest() {
        MyLinkedList myLinkedList = getMyLinkedList();
        myLinkedList.removeDuplicates();
        assertThat(foundDuplicates(myLinkedList.getHead())).isFalse();
    }

    @Test
    void removeDuplicatesDuplicatesTest() {
        MyLinkedList linkedListWithDuplicates = new MyLinkedList(1);
        linkedListWithDuplicates.append(2);
        linkedListWithDuplicates.append(3);
        linkedListWithDuplicates.append(3);
        linkedListWithDuplicates.append(4);
        linkedListWithDuplicates.append(4);
        linkedListWithDuplicates.append(5);

        MyLinkedList expectedLinkedList = getMyLinkedList();

        linkedListWithDuplicates.removeDuplicates();
        assertThat(foundDuplicates(linkedListWithDuplicates.getHead())).isFalse();
    }

    @Test
    void reverseBetweenTest() {
        // Given
        final int headValue = 1;
        List<Integer> next = List.of( 2, 3, 4, 5);
        MyLinkedList linkedList = new MyLinkedList(headValue);
        next.forEach(linkedList::append);
        // When
        linkedList.reverseBetween(1, 3);
        // Then
        List<Integer> expectedContent = List.of(1, 4, 3, 2, 5);
        List<Integer> actualContent = new ArrayList<>();
        MyLinkedList.Node node = linkedList.getHead();
        while (node != null){
            actualContent.add(node.value);
            node = node.next;
        }

        assertThat(actualContent).isEqualTo(expectedContent);
    }

    private boolean foundDuplicates(MyLinkedList.Node node) {
        Map<Integer, Boolean> uniqueMap = new HashMap<>();
        while (node != null) {
            if (uniqueMap.get(node.value) == null) {
                uniqueMap.put(node.value, true);
            } else {
                uniqueMap.put(node.value, false);
            }
            node = node.next;
        }
        return uniqueMap.containsValue(Boolean.FALSE);
    }


    private static MyLinkedList getMyLinkedList() {
        MyLinkedList myLinkedList = new MyLinkedList(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.append(4);
        myLinkedList.append(5);
        return myLinkedList;
    }
}
