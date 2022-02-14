class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        for(int i=0;i<word1.length;i++)
        {
            sb.append(word1[i]);
        }
        for(int i=0;i<word2.length;i++)
        {
            sb1.append(word2[i]);
        }
        return (sb.toString()).equals(sb1.toString());
    }
}