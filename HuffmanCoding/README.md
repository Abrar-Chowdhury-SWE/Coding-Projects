Refer to the "HuffmanCoding" file to run through all the methods.


This code implements the Huffman coding algorithm for encoding and decoding data. The Huffman coding is a lossless data compression technique that assigns variable-length codes to different characters based on their frequencies in the input data, where the more frequent characters get shorter codes and less frequent characters get longer codes. Let's go through the main components and functionalities of the code:

Constructor: The constructor takes a filename as input, which represents the file that needs to be encoded.

makeSortedList(): This method reads from the file character by character and creates a sorted list of CharFreq objects. CharFreq is a class that holds information about a character and its frequency in the input file.

makeTree(): Using the sorted list of CharFreq objects, this method builds a Huffman coding tree and stores its root in huffmanRoot. The tree is built using a priority queue (here implemented using the Queue class).

makeEncodings(): This method uses the Huffman coding tree to create a string array of size 128, where each index in the array contains the bitstring encoding for the corresponding ASCII character. Characters not present in the Huffman coding tree will have their spots in the array left null.

encode(): This method reads the file character by character, converts the characters into their respective Huffman encodings, and writes the final encoding of 1's and 0's to the encoded file. It uses the writeBitString() method to write the binary data into the file.

decode(): This method takes a previously encoded file and its corresponding Huffman coding tree. It converts the encoded bitstring back into characters using the Huffman tree and writes the decoded data to a new file.

readBitString() and writeBitString(): These are helper methods used for reading and writing bitstrings to/from files.

The Huffman coding tree is constructed in makeTree() using a priority queue to efficiently find the two nodes with the lowest probabilities (frequencies) and merge them into a new parent node until the tree is fully constructed.

Overall, this class provides functionalities to encode and decode data using the Huffman coding technique, which is useful for compressing and decompressing data efficiently while preserving its original content.
