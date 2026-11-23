class ListNode:
    def __init__(self, val: int, next_node: Optional["ListNode"] = None):
        self.val = val
        self.next = next_node

class LinkedList:
    
    def __init__(self):
        self.dummy = ListNode(0) # dummy.next is head
        self.tail = self.dummy
        self.size = 0
        
    def get(self, index: int) -> int:
        if index < 0 or index >= self.size:
            return -1
        
        current = self.dummy.next
        for _ in range(index):
            current = current.next
        
        return current.val
        
    def insertHead(self, val: int) -> None:
        new_node = ListNode(val)
        # newNode.next = [head]
        new_node.next = self.dummy.next 
        # [dummy.next] = newNode
        self.dummy.next = new_node

        if self.size == 0:
            self.tail = new_node

        self.size += 1

    def insertTail(self, val: int) -> None:
        # ... -> [tail] -> None
        # ... -> [tail] -> new_node -> None
        # ... -> [old tail] -> [new tail] -> None
        new_node = ListNode(val)
        self.tail.next = new_node
        self.tail = new_node
        self.size += 1


    def remove(self, index: int) -> bool:
        # Empty list, index out of bounds
        if self.size == 0 or index < 0 or index >= self.size:
            return False

        prev = self.dummy
        current = self.dummy.next

        if index == 0:
            prev.next = current.next

        for _ in range(index):
            prev = current
            current = current.next

        prev.next = current.next

        if current == self.tail:
            self.tail = prev

        self.size -= 1
        return True

    def getValues(self) -> List[int]:
        values = []

        current = self.dummy.next
        while current != None:
            values.append(current.val)
            current = current.next

        return values
        