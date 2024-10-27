public class FirstSingleLetter {
    

        public char firstSingleLetter(char[] text) {
            if (text.length == 0) {
                System.out.println("Array is Empty");
                return 0;
            }
    
            for (int i = 0; i < text.length; i++) {
                boolean isSingle = true;
                for (int j = 0; j < text.length; j++) {
                    if (i != j && text[i] == text[j]) {
                        isSingle = false;
                        break;
                    }
                }
                if (isSingle) {
                    return text[i];
                }
            }
            System.out.println("No nonDuplicating Letters found");
            return 0;
        }
    }
    

