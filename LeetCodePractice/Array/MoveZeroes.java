int count0 = 0; # Initialised to count the number of zeros
        int k = 0; # Intitalised to manipulate the array 
        for ( int i = 0 ; i < nums.length ; i++)
        {
            if ( nums[i] != 0) #If nums of i is not equal to zero then we can manipulate the array from the begining  
            {
                nums[k] = nums[i];
                k++; 
            }
            else
            {
                count0++; #count0 is increased on finding a zero
            } 
        }
        while ( count0 >= 0 && k< nums.length)
        {
            nums[k] =0; # k will now be the number of non zero number hence did not initialise a new variable
            k++; # to traverse the array
            count0--; #reduce the count of 0 after adding 0 to the end of the array
        }