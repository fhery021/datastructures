package dsa.ll;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ListNodeTest {

    @Test
    void partition() {
        // Given
        ListNode listNode = new ListNode(1);
        listNode.append(4)
                .append(3)
                .append(2)
                .append(5)
                .append(2);

        // When
        ListNode partitioned = listNode.partition(listNode, 3);
        // Then
        ListNode expected = new ListNode(1);
        expected.append(2)
                .append(2)
                .append(4)
                .append(3)
                .append(5);
        assertThat(partitioned).isEqualTo(expected);
    }


    @Test
    void deleteDuplicatesTest() {
        // Given
        ListNode listNode = new ListNode(1);
        listNode.append(1)
                .append(1)
                .append(2);

        // When
        ListNode noDuplicates = listNode.deleteDuplicates(listNode);
        // Then
        ListNode expected = new ListNode(1);
        expected.append(2);
        assertThat(noDuplicates).isEqualTo(expected);
    }

}
