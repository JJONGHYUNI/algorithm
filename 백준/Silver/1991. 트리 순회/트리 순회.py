import sys

input = sys.stdin.readline

n = int(input())
class Node:
    def __init__(self, data, left_node, right_node):
        self.data = data
        self.left_node = left_node
        self.right_node = right_node
def preOrder(node):
    print(node.data, end = '')
    if node.left_node != '.':
        preOrder(t[node.left_node])
    if node.right_node != '.':
        preOrder(t[node.right_node])
def inOrder(node):
    if node.left_node != '.':
        inOrder(t[node.left_node])
    print(node.data, end = '')
    if node.right_node != '.':
        inOrder(t[node.right_node])
def postOrder(node):
    if node.left_node != '.':
        postOrder(t[node.left_node])
    if node.right_node != '.':
        postOrder(t[node.right_node])
    print(node.data, end = '')
t = {}
for _ in range(n):
    data, left_node, right_node = input().split()
    t[data] = Node(data, left_node, right_node)
preOrder(t['A'])
print()
inOrder(t['A'])
print()
postOrder(t['A'])
