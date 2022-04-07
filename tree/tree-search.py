#5639
import sys
sys.setrecursionlimit(18000)
input = sys.stdin.readline
class Node:
    def __init__(self,data):
        self.data=data
        self.left=None
        self.right=None

class Tree:
    def __init__(self):
        self.root=None

    def add(self,data):
        if self.root==None:
            self.root=Node(data)
        else:
            now_data=self.root
            #크면 오른쪽 작으면 왼쪽
            while True:
                if now_data.data>data:
                    if now_data.left==None:
                        now_data.left=Node(data)
                        break
                    now_data=now_data.left
                elif now_data.data<data:
                    if now_data.right==None:
                        now_data.right=Node(data)
                        break
                    now_data=now_data.right

    def post_order(self,node=None):
        if node==None:
            node=self.root

        if node.left != None:
            self.post_order(node.left)
        if node.right != None:
            self.post_order(node.right)
        print(node.data)
tree=Tree()
while True:
    try:
        tree.add(int(input()))
    except:
        break
tree.post_order()
