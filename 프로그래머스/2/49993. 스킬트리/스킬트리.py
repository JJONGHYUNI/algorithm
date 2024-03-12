def solution(skill, skill_trees):
    answer = len(skill_trees)
    sk = skill.strip()
    for skill_tree in skill_trees:
        temp = []
        
        for cur in skill_tree.strip():
            if cur in sk:
                temp.append(cur)
        for i in range(len(temp)):
            if temp[i] != sk[i]:
                answer -= 1
                break
            
    return answer