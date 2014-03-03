import java.util.Stack;

public class DataStruts {

    public LinkedListNode createList(int... values) {
        if (values.length == 0) {
            return null;
        }

        LinkedListNode head = null;
        LinkedListNode current = head;
        for(int value : values) {
            LinkedListNode newNode = new LinkedListNode();
            newNode.setData(value);
            newNode.setNext(null);

            LinkedListNode addedNode = appendNode(current, newNode);
            if (head == null) {
                head = addedNode;
            }

            current = addedNode;
        }

        return head;
    }


    public LinkedListNode spiltLinkedList(LinkedListNode node, int value) {
        LinkedListNode result = null;

        if (node == null) {
            return null;
        }

        LinkedListNode beforeValueHead = null;
        LinkedListNode afterValueHead= null;
        LinkedListNode beforeValueCurrent = null;
        LinkedListNode afterValueCurrent = null;
        LinkedListNode current = node;
        while (current != null) {
            if (current.getData() < value) {
                LinkedListNode addedNode = appendNode(beforeValueCurrent, current);
                if (beforeValueHead == null) {
                    beforeValueHead = addedNode;
                }
                beforeValueCurrent = addedNode;
            } else {
                LinkedListNode addedNode = appendNode(afterValueCurrent, current);
                if (afterValueHead == null) {
                    afterValueHead = addedNode;
                }
                afterValueCurrent = addedNode;
            }
            current = current.getNext();
        }

        if (beforeValueHead != null) {
            result = beforeValueHead;
            beforeValueCurrent.setNext(afterValueHead);
        } else {
            result = afterValueHead;
        }

        return result;
    }

    public LinkedListNode getNthNodeToLast(LinkedListNode head, int value) {
        if (head == null) {
            return null;
        }

        LinkedListNode current = head;
        LinkedListNode fwded = current;
        int fastFwdCount = 0;
        while (fastFwdCount != value) {
            if (fwded == null) {
                return null;
            }
            fwded = fwded.getNext();
            fastFwdCount++;
        }

        while (fwded.getNext() != null) {
            fwded = fwded.getNext();
            current = current.getNext();
        }

        return current;
    }

    public LinkedListNode addLists(LinkedListNode list1, LinkedListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        int carry = 0;
        LinkedListNode headToReturn = null;
        LinkedListNode current = headToReturn;
        while (list1 != null && list2 != null) {
            int list1Value = list1.getData();
            int list2Value = list2.getData();

            LinkedListNode newNode = new LinkedListNode();
            carry = addValues(list1Value, list2Value, carry, newNode);
            LinkedListNode appendedNode = appendNode(current, newNode);
            if (headToReturn == null) {
                headToReturn = appendedNode;
            }

            current = appendedNode;

            list1 = list1.getNext();
            list2 = list2.getNext();
        }

        while (true) {
            LinkedListNode currentListNode = null;
            int currentListValue = 0;
            if (list1 != null) {
                currentListNode = list1;
                currentListValue = list1.getData();
                list1 = list1.getNext();
            }

            if (list2 != null) {
                currentListNode = list2;
                currentListValue = list2.getData();
                list2 = list2.getNext();
            }

            if (carry == 0) {
                if (currentListNode != null) {
                    current.setNext(currentListNode);
                }
                break;
            }

            LinkedListNode newNode = new LinkedListNode();
            carry = addValues(currentListValue, 0, carry, newNode);
            current.setNext(newNode);
            current = current.getNext();
        }


        return headToReturn;
    }

    public boolean isCircular(LinkedListNode head) {
        if (head == null) {
            return false;
        }

        LinkedListNode current = head;
        LinkedListNode fastRunner = null;

        if (current.getNext() != null) {
            fastRunner = current.getNext().getNext();
        }

        while (true) {
            if (fastRunner == null) {
                return false;
            }

            if (fastRunner == current) {
                break;
            }

            fastRunner = fastRunner.getNext();
            if (fastRunner != null) {
                fastRunner = fastRunner.getNext();
            }
            current = current.getNext();
        }

        return true;
    }

    public LinkedListNode getMidOfLinkList(LinkedListNode head) {
        if (head == null || head.getNext() == null) {
            return null;
        }

        LinkedListNode current = head;
        LinkedListNode runner = head;

        while (runner != null && runner.getNext() != null) {
            current = current.getNext();
            runner = runner.getNext();
            if (runner != null) {
                runner = runner.getNext();
            }

            if (runner == current) {
                return null; // circular, cannot find mid.
            }
        }

        return current;
    }

    public boolean isListPalindrome(LinkedListNode head) {
        if (head == null) {
            return false;
        }

        LinkedListNode current = head;
        LinkedListNode runner = head;
        Stack<Integer> myStack = new Stack<Integer>();
        while (runner != null && runner.getNext() != null) {
            myStack.push(current.getData());
            current = current.getNext();
            runner = runner.getNext();
            if (runner != null) {
                runner = runner.getNext();
            }

            if (runner == current) {
                return false; // circular, cannot find mid.
            }
        }

        if (myStack.empty()) {
            return true;
        }

        //Odd
        if (runner != null && runner.getNext() == null) {
            current = current.getNext();
        }

        while (current != null) {
            if (current.getData() != myStack.peek()) {
                return false;
            }
            myStack.pop();
            current = current.getNext();
        }

        return true;
    }



    private int addValues(int value1, int value2, int carry, LinkedListNode node){
        int sum = value1 + value2 + carry;
        int remainder = sum % 10;
        carry = sum / 10;

        node.setData(remainder);
        node.setNext(null);

        return carry;
    }


    private LinkedListNode appendNode(LinkedListNode currentNode, LinkedListNode nodeToAdd) {
        if (currentNode == null) {
            currentNode = nodeToAdd;
            return currentNode;
        }

        currentNode.setNext(nodeToAdd);
        return currentNode.getNext();
    }
}
