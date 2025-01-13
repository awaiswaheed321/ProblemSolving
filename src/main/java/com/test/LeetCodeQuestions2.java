package com.test;

import java.util.*;

public class LeetCodeQuestions2 {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(finalPrices(new int[]{8,4,6,2,3})));
//        System.out.println(Arrays.toString(finalPrices(new int[]{1,2,3,4,5})));
//        System.out.println(Arrays.toString(finalPrices(new int[]{10,1,1,6})));
//        System.out.println(isHappy(14));
//        System.out.println(isHappy(2));
//        System.out.println(canJump(new int[] { 3,2,1,0,4}));
//        System.out.println(canJump2(new int[] {3,2,1,1,4}));
//        System.out.println(Math.pow(0,2));
//        List<List<String>> responses = List.of(fullJustify(new String[]{"Science","is","what","we","understand",
//        "well","enough","to","explain","to",
//                "a","computer.","Art","is","everything","else","we","do"}, 20),
//                fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16));
//        int number = 1;
//        for (List<String> innerList : responses) {
//            System.out.println(number + ": ");
//            for(String s: innerList) {
//                System.out.println(s + ":" + s.length());
//            }
//            number++;
//        }
//        System.out.println(selfDividingNumbers(47, 85));
//        System.out.println(getSum(-2,-3));
//        System.out.println(heightChecker(new int[]{1,1,4,2,1,3}));

//        System.out.println(addBinary("101111", "10"));
//        ListNode list = createList();
//        ListNode newList = rotateRight(list,2);
//        printList(newList);

//        System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));

//        ListNode list = createList();
//        ListNode newList = deleteDuplicates(list);
//        printList(newList);

//        int[][] matrix = {
//                {1, 2, 3},
//                {4, 0, 6},
//                {7, 8, 9}
//        };
//
//        System.out.println("Original Matrix:");
//        printMatrix(matrix);
//
//        setZeros(matrix);
//
//        System.out.println("Matrix after calling setZeros:");
//        printMatrix(matrix);

//        System.out.println(findMin(new int[]{2, 2, 2, 0, 1}));

//        int[][] intervals = {
//                {1, 3}, {6, 9}
//        };
//
//        int[][] res = insert(intervals, new int[] {2,5});
//        printMatrix(res);
//        System.out.println(mySqrt(2147395599));

//        System.out.println(maxScore("00"));

//        int[][] shifts = {
//                {0, 2}, {1, 4}, {1, 1}
//        };
//        String[] strings = {"aba", "bcb", "ece", "aa", "e"};
//        System.out.println(Arrays.toString(vowelStrings(strings, shifts)));

//        String[] words = {"pay", "attention", "practice", "attend"};
//        System.out.println(prefixCount(words, "at"));

        System.out.println(grayCode2(0));
        System.out.println(grayCode2(1));
        System.out.println(grayCode2(3));
    }

    public static List<Integer> grayCode2(int n) {
        List<Integer> res = new ArrayList<>();
        int len = (int) Math.pow(2, n);
        for(int i = 0; i < len; i++) {
            res.add(i ^ (i >> 1));
        }
        return res;
    }

    public static List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        for (int i = 1; i <= n; i++) {
            List<Integer> old = new ArrayList<>(res);
            Collections.reverse(old);
            for (Integer j : old) {
                res.add(j + (int) Math.pow(2, i - 1));
            }
        }
        return res;
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String word : strs) {
            char[] arr = word.toCharArray();
            Arrays.sort(arr);
            String sortedWord = new String(arr);
            List<String> list = map.getOrDefault(sortedWord, new ArrayList<>());
            list.add(word);
            map.put(sortedWord, list);
        }
        return new ArrayList<>(map.values());
    }

    public static int prefixCount(String[] words, String pref) {
        int count = 0;
        for (String word : words) {
            if (pref.length() <= word.length() && word.startsWith(pref)) {
                count++;
            }
        }
        return count;
    }

    public static List<String> mostActiveUser(List<String> logs, int n) {
        Map<String, Integer> counts = new HashMap<>();
        logs.forEach(l -> {
            String[] words = l.split(" ");
            if (words[0].equals(words[1])) {
                counts.put(words[0], counts.getOrDefault(words[0], 0) + 1);
            } else {
                counts.put(words[0], counts.getOrDefault(words[0], 0) + 1);
                counts.put(words[1], counts.getOrDefault(words[1], 0) + 1);
            }
        });

        List<String> users = new ArrayList<>();
        counts.forEach((k, v) -> {
            if (v >= n) {
                users.add(k);
            }
        });
        users.sort(Comparator.comparingInt(Integer::parseInt));
        return users;
    }

    public static int[] vowelStrings(String[] words, int[][] queries) {
        int[] res = new int[queries.length];
        int[] vowelCounts = new int[words.length + 1];
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        int curr = 0;
        for (int i = 0; i < words.length; i++) {
            if (vowels.contains(words[i].charAt(0)) && vowels.contains(words[i].charAt(words[i].length() - 1))) {
                curr++;
            }
            vowelCounts[i + 1] = curr;
        }
        for (int i = 0; i < queries.length; i++) {
            res[i] = vowelCounts[queries[i][1] + 1] - vowelCounts[queries[i][0]];
        }
        return res;
    }

    public static String shiftingLetters3(String s, int[][] shifts) {
        int[] shiftArray = new int[s.length() + 1];
        for (int[] shift : shifts) {
            int direction = shift[2] == 0 ? -1 : 1;
            shiftArray[shift[0]] += direction;
            shiftArray[shift[1] + 1] -= direction;
        }
        int cumulative = 0;
        int[] cumulativeShifts = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            cumulative += shiftArray[i];
            cumulativeShifts[i] = (cumulative % 26 + 26) % 26;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            result.append((char) ((c - 'a' + cumulativeShifts[i]) % 26 + 'a'));
        }
        return result.toString();
    }

    public static String shiftingLetters2(String s, int[][] shifts) {
        int[] requiredShifts = new int[s.length()];
        for (int[] shift : shifts) {
            for (int i = shift[0]; i <= shift[1]; i++) {
                if (shift[2] == 0) {
                    requiredShifts[i]--;
                } else {
                    requiredShifts[i]++;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < requiredShifts.length; i++) {
            char c = s.charAt(i);
            int shift = requiredShifts[i];
            if (shift == 0) {
                stringBuilder.append(c);
            } else {
                shift = (shift % 26 + 26) % 26;
                stringBuilder.append((char) ((c - 'a' + shift) % 26 + 'a'));
            }
        }
        return stringBuilder.toString();
    }

    public static String shiftingLetters(String s, int[][] shifts) {
        for (int[] shift : shifts) {
            StringBuilder sb = new StringBuilder();
            char[] chars = s.toCharArray();
            int i = 0;
            while (i < shift[0]) {
                sb.append(chars[i++]);
            }
            for (; i <= shift[1]; i++) {
                if (shift[2] == 0) {
                    sb.append((char) ((chars[i] - 'a' - 1 + 26) % 26 + 'a'));
                } else {
                    sb.append((char) ((chars[i] - 'a' + 1) % 26 + 'a'));
                }
            }
            while (i < chars.length) {
                sb.append(chars[i++]);
            }
            s = sb.toString();
        }
        return s;
    }

    public static int maxScore(String s) {
        int right1s = 0, totalSum = 0, left0s = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                right1s++;
            }
        }
        for (int i = 0; i < s.length() - 1; i++) {
            char c = s.charAt(i);
            if (c == '0') {
                left0s++;
            } else {
                right1s--;
            }
            if (left0s + right1s > totalSum) {
                totalSum = left0s + right1s;
            }
        }
        return totalSum;
    }

    public static int mySqrt(int x) {
        int start = 1, end = x;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid == x / mid) {
                return mid;
            } else if (mid < x / mid) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end;
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            list.add(intervals[i++]);
        }
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        list.add(newInterval);
        while (i < intervals.length) {
            list.add(intervals[i++]);
        }
        return list.toArray(new int[list.size()][]);
    }

    public static int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
            if (i > 0 && nums[i] < nums[i - 1]) {
                break;
            }
        }
        return min;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void setZeros(int[][] matrix) {
        int rowSize = matrix.length;
        int colSize = matrix[0].length;
        boolean[] rows = new boolean[rowSize];
        boolean[] columns = new boolean[colSize];
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    columns[j] = true;
                }
            }
        }
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (rows[i] || columns[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head != null) {
            ListNode temp = head;
            while (temp.next != null) {
                if (temp.next.val == temp.val) {
                    ListNode next = temp.next;
                    temp.next = temp.next.next;
                    next.next = null;
                } else {
                    temp = temp.next;
                }
            }
        }
        return head;
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();
        for (int a = 0; a < nums.length; a++) {
            if (a > 0 && nums[a] == nums[a - 1]) continue;

            for (int b = a + 1; b < nums.length; b++) {
                if (b > a + 1 && nums[b] == nums[b - 1]) continue;

                for (int c = b + 1; c < nums.length; c++) {
                    if (c > b + 1 && nums[c] == nums[c - 1]) continue;

                    for (int d = c + 1; d < nums.length; d++) {
                        long sum = (long) nums[a] + nums[b] + nums[c] + nums[d];

                        if (sum == target) {
                            res.add(List.of(nums[a], nums[b], nums[c], nums[d]));
                        }
                    }
                }
            }
        }
        return new ArrayList<>(res);
    }


    public static ListNode rotateRight(ListNode head, int k) {
        ListNode temp = head;
        int size = 1;
//        Check total size of nodes
        while (temp.next != null) {
            size++;
            temp = temp.next;
        }
//        Check rotations required
        int rotations = k % size;
        if (rotations == 0) {
            return head;
        }
//        Go to nodes required to rotate
        ListNode fastPointer = head;
        while (rotations > 0) {
            fastPointer = fastPointer.next;
            rotations--;
        }
        ListNode slowPointer = head;
        while (fastPointer.next != null) {
            fastPointer = fastPointer.next;
            slowPointer = slowPointer.next;
        }
//        Split the nodes to rotate
        ListNode rotateNodes = slowPointer.next;
        slowPointer.next = null;
//        Reverse the split nodes
//        rotateNodes = reverse(rotateNodes);
        ListNode newHead = rotateNodes;
//        Append nodes to start of original
        while (rotateNodes.next != null) {
            rotateNodes = rotateNodes.next;
        }
        rotateNodes.next = head;
        return newHead;
    }

    // Function to create a linked list 1 -> 2 -> 3 -> 4 -> 5 -> null
    public static ListNode createList() {
        ListNode head = new ListNode(1);
        ListNode current = head;

        for (int i = 2; i <= 5; i++) {
            current.next = new ListNode(i);
            current = current.next;
        }

        return head;
    }

    // Function to print the linked list
    public static void printList(ListNode head) {
        ListNode current = head;

        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println(" -> null");
    }

    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }

    public static String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int carry = 0;
        while (!a.isEmpty() && !b.isEmpty()) {
            int a1 = a.charAt(a.length() - 1) % 48;
            int b1 = b.charAt(b.length() - 1) % 48;
            int sum = a1 + b1 + carry;
            carry = sum / 2;
            int sumToAdd = sum % 2;
            res.insert(0, sumToAdd);
            a = a.substring(0, a.length() - 1);
            b = b.substring(0, b.length() - 1);
        }
        if (!a.isEmpty()) {
            carry = appendRemaining(a, res, carry);
        } else if (!b.isEmpty()) {
            carry = appendRemaining(b, res, carry);
        }
        if (carry == 1) {
            res.insert(0, "1");
        }
        return res.toString();
    }

    public static int appendRemaining(String s, StringBuilder res, int carry) {
        while (!s.isEmpty()) {
            int b1 = s.charAt(s.length() - 1) % 48;
            int sum = b1 + carry;
            carry = sum / 2;
            int sumToAdd = sum % 2;
            res.insert(0, sumToAdd);
            s = s.substring(0, s.length() - 1);
        }
        return carry;
    }

    public static int heightChecker(int[] heights) {
        int[] fixed = new int[heights.length];
        System.arraycopy(heights, 0, fixed, 0, heights.length);
        Arrays.sort(fixed);
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != fixed[i]) {
                count++;
            }
        }
        return count;
    }

    public static int getSum(int a, int b) {
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }
        if ((a < 0 && b < 0) || (a > 0 && b < 0)) {
            while (b < 0) {
                a--;
                b++;
            }
        } else if ((a > 0 && b > 0) || (a < 0 && b > 0)) {
            while (b > 0) {
                a++;
                b--;
            }
        }
        return a;
    }


    public void sortColors(int[] nums) {
        int count0 = 0, count1 = 0, count2 = 0;
        for (int num : nums) {
            if (num == 0) {
                count0++;
            } else if (num == 1) {
                count1++;
            } else {
                count2++;
            }
        }
        int index = 0;
        while (count0 > 0) {
            nums[index++] = 0;
            count0--;
        }
        while (count1 > 0) {
            nums[index++] = 1;
            count1--;
        }
        while (count2 > 0) {
            nums[index++] = 2;
            count2--;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        if (slow == head && slow.next == null) {
            return null;
        } else if (slow != null && slow.next != null) {
            slow.next = slow.next.next;
        }
        return head;
    }

    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isSelfDividing(i)) {
                result.add(i);
            }
        }
        return result;
    }

    private static boolean isSelfDividing(int i) {
        int num = i;
        while (num > 0) {
            int temp = num % 10;
            num = num / 10;
            if (temp == 0) {
                return false;
            }
            if (i % temp != 0) {
                return false;
            }
        }
        return true;
    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < words.length) {
            List<String> row = new ArrayList<>();
            int rowLength = 0;

            // Pack words into the row
            while (i < words.length && rowLength + words[i].length() + row.size() <= maxWidth) {
                row.add(words[i]);
                rowLength += words[i].length();
                i++;
            }

            // Determine the number of spaces to distribute
            int totalSpaces = maxWidth - rowLength;

            // Last line or row with only one word: left-justified
            if (i == words.length || row.size() == 1) {
                StringBuilder lastLine = new StringBuilder(String.join(" ", row));
                while (lastLine.length() < maxWidth) {
                    lastLine.append(" ");
                }
                result.add(lastLine.toString());
            } else {
                // Fully justify the current line
                List<Integer> spaces = new ArrayList<>();
                for (int j = 0; j < row.size() - 1; j++) {
                    spaces.add(1); // At least one space between words
                }

                distributeSpaces(spaces, totalSpaces);

                StringBuilder line = new StringBuilder();
                for (int j = 0; j < row.size(); j++) {
                    line.append(row.get(j));
                    if (j < spaces.size()) {
                        line.append(" ".repeat(spaces.get(j)));
                    }
                }
                result.add(line.toString());
            }
        }

        return result;
    }

    public static void distributeSpaces(List<Integer> spaces, int totalSpaces) {
        int size = spaces.size();
        int equalShare = totalSpaces / size;
        int remainder = totalSpaces % size;

        for (int i = 0; i < spaces.size(); i++) {
            int extraSpace = equalShare + (remainder > 0 ? 1 : 0);
            spaces.set(i, spaces.get(i) + extraSpace);
            remainder--;
        }
    }

    public static boolean canJump2(int[] nums) {
        int finalPos = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] + i >= finalPos) {
                finalPos = i;
            }
        }
        return finalPos == 0;
    }

    public static boolean canJump(int[] nums) {
        return reachGoal(nums, nums.length - 1);
    }

    public static boolean reachGoal(int[] nums, int goalIndex) {
        if (goalIndex == 0) {
            return true;
        }
        if (goalIndex == -1) {
            return false;
        }
        int maxJumpIndex = -1;
        for (int i = goalIndex - 1; i >= 0; i--) {
            if (nums[i] + i >= goalIndex && nums[i] + i > maxJumpIndex) {
                maxJumpIndex = i;
            }
        }
        return reachGoal(nums, maxJumpIndex);
    }

    public static boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<>();
        while (n != 1 && !visited.contains(n)) {
            visited.add(n);
            n = getSquaredSum(n);
        }
        return n == 1;
    }

    public static int getSquaredSum(int n) {
        int squaredSum = 0;
        while (n > 0) {
            int temp = n % 10;
            squaredSum += temp * temp;
            n = n / 10;
        }
        return squaredSum;
    }

    public static int[] finalPrices(int[] prices) {
        int[] finalPrices = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            finalPrices[i] = prices[i];
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] >= prices[j]) {
                    finalPrices[i] -= prices[j];
                    break;
                }
            }
        }
        return finalPrices;
    }
}
