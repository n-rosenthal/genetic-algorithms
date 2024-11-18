""" Tests suite for the `Genes.py` module.
"""

from unittest import TestCase;
import primitives.Genes as Genes;
from primitives.Genes import Gene;

class GeneTests(TestCase):
    """Tests suite for the `Gene` class."""
    def runTest(self) -> None:
        self.initializationTests();
        self.representationTests();
        self.propertyTests();
        
        
    def initializationTests(self) -> None:
        """
        Tests the initialization of a `Gene` object
        """
        #   Normal initialization of a `Gene` object
        gene = Genes.Gene();
        self.assertEqual(len(gene), 1);
        self.assertEqual(gene[0], 0);
        
        print("Success initialization of a `Gene` object");
        
        #   Initialization of a `Gene` object with a specific length
        gene = Genes.Gene(10);
        self.assertEqual(len(gene), 10);
        self.assertEqual(gene[0], 0);
        
        print("Success initialization of a `Gene` object with a specific length");
        
        #   Initialization of a `Gene` object with a specific value
        gene = Genes.Gene(10, bytearray([1, 2, 3, 4, 5, 6, 7, 8, 9, 10]));
        self.assertEqual(len(gene), 10);
        self.assertEqual(gene[0], 1);
        self.assertEqual(gene[9], 10);
    
        print("Success initialization of a `Gene` object with a specific value");
    
    def representationTests(self) -> None:
        """
        Tests the representation of a `Gene` object
        """
        #   String representation of a `Gene` object
        gene = Genes.Gene(10, bytearray([1, 2, 3, 4, 5, 6, 7, 8, 9, 10]));
        self.assertEqual(str(gene), "[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]");
        
        print("Success string representation of a `Gene` object");
        
        
        #   Bytearray representation of a `Gene` object
        # gene = Genes.Gene(10, bytearray([1, 2, 3, 4, 5, 6, 7, 8, 9, 10]));
        # self.assertEqual(repr(gene), "bytearray(b'\\x01\\x02\\x03\\x04\\x05\\x06\\x07\\x08\\x09\\x0a')");
        
        # print("Success bytearray representation of a `Gene` object");
        
        #   Integer representation of a `Gene` object
        gene = Genes.Gene(10, bytearray([1, 2, 3, 4, 5, 6, 7, 8, 9, 10]));
        self.assertEqual(int(gene), 12345678910);
        
        print("Success integer representation of a `Gene` object");
        
    
    def propertyTests(self) -> None:
        """
        Tests the properties of a `Gene` object
        """
        #   Length property of a `Gene` object
        gene = Genes.Gene(10, bytearray([1, 2, 3, 4, 5, 6, 7, 8, 9, 10]));
        self.assertEqual(gene.length, 10);
        
        print("Success length property of a `Gene` object");
        
        #   Value property of a `Gene` object
        gene = Genes.Gene(10, bytearray([1, 2, 3, 4, 5, 6, 7, 8, 9, 10]));
        self.assertEqual(gene.value, bytearray([1, 2, 3, 4, 5, 6, 7, 8, 9, 10]));
        
        print("Success value property of a `Gene` object");


class BitGeneTests(TestCase):
    """Tests suite for the `BitGene` class."""
    def runTest(self) -> None:
        self.initializationTests();
        self.representationTests();
        self.propertyTests();
        
    def initializationTests(self) -> None:
        """
        Tests the initialization of a `BitGene` object
        """
        #   Normal initialization of a `BitGene` object
        gene = Genes.BitGene();
        self.assertEqual(len(gene), 1,
                         msg="Normal initialization of a `BitGene` object");
        self.assertEqual(gene[0], 0,
                         msg="Normal initialization of a `BitGene` object");
        
        #   Initialization of a `BitGene` object with a specific length
        gene = Genes.BitGene(10);
        self.assertEqual(len(gene), 10,
                         msg="Initialization of a `BitGene` object with a specific length");
        self.assertEqual(gene[0], 0,
                         msg="Initialization of a `BitGene` object with a specific length");
        
        #   Initialization of a `BitGene` object with a specific value
        gene = Genes.BitGene(10, bytearray([1, 0, 1, 0, 1, 0, 1, 0, 1, 0]));
        self.assertEqual(len(gene), 10,
                         msg="Initialization of a `BitGene` object with a specific value");
        self.assertEqual(gene[0], 1,
                         msg="Initialization of a `BitGene` object with a specific value");
        self.assertEqual(gene[9], 0,
                         msg="Initialization of a `BitGene` object with a specific value");
        
    def representationTests(self) -> None:
        """
        Tests the representation of a `BitGene` object
        """
        #   String representation of a `BitGene` object
        gene = Genes.BitGene(10, bytearray([1, 0, 1, 0, 1, 0, 1, 0, 1, 0]));
        self.assertEqual(str(gene), "[1, 0, 1, 0, 1, 0, 1, 0, 1, 0]",
                         msg="String representation of a `BitGene` object");
        
        #   Bytearray representation of a `BitGene` object
        #gene = Genes.BitGene(10, bytearray([1, 0, 1, 0, 1, 0, 1, 0, 1, 0]));
        #self.assertEqual(repr(gene), "bytearray(b'\\x01\\x00\\x01\\x00\\x01\\x00\\x01\\x00\\x01\\x00')",
        #                 msg="Bytearray representation of a `BitGene` object");
        
        #   Integer representation of a `BitGene` object
        gene = Genes.BitGene(10, bytearray([1, 0, 1, 0, 1, 0, 1, 0, 1, 0]));
        self.assertEqual(int(gene), int("1010101010", 10),
                         msg="Integer representation of a `BitGene` object");
        
    def propertyTests(self) -> None:
        """
        Tests the properties of a `BitGene` object
        """
        #   Length property of a `BitGene` object
        gene = Genes.BitGene(10, bytearray([1, 0, 1, 0, 1, 0, 1, 0, 1, 0]));
        self.assertEqual(gene.length, 10,
                         msg="Length property of a `BitGene` object");
        
        #   Value property of a `BitGene` object
        gene = Genes.BitGene(10, bytearray([1, 0, 1, 0, 1, 0, 1, 0, 1, 0]));
        self.assertEqual(gene.value, bytearray([1, 0, 1, 0, 1, 0, 1, 0, 1, 0]),
                         msg="Value property of a `BitGene` object");
        

if __name__ == "__main__":
    import unittest;
    unittest.main();
    exit(0);