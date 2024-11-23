""" `Genes.py` module
The `Genes.py` module contains the `Gene` class, which is a single element of a `Chromosome`.
"""

from __future__ import annotations;

import random;
from random import randint;
from typing import List;
from abc import ABC, abstractmethod;

def normalize(integer: int) -> int:
    return integer % 2;

def INT_TO_BITS(value: int, base: int = 2) -> list[int]:
    return [int(bit) for bit in bin(value)[2:].zfill(base)];

def BITS_TO_FLOAT(bits: list[int], base: int = 2) -> float:
    return float(int("".join([str(x) for x in bits]), base)) / (2**len(bits) - 1);

def FLOAT_TO_BITS(value: float, base: int = 2) -> list[int]:
    return INT_TO_BITS(int(value * (2**base - 1)), base);

def BITS_TO_INT(bits: list[int], base: int = 2) -> int:
    return int("".join([str(x) for x in bits]), base);

class Gene(ABC):
    """A `Gene` is a single element of a `Chromosome`. It is implement as an array of bits.
    
    Attributes:
        value (list[int]): A list of bits that represent the value of the `Gene`.
        
    Methods:
        __int__(self, base: int = 2)        : Returns the value of the `Gene` as an integer.
        mutate(self, probability: float)    : Mutates the `Gene` with a given probability. Should be overridden in subclasses.
        crossover(self, other: Gene)        : Crossovers the `Gene` with another `Gene`. Should be overridden in subclasses.
    """
    def __init__(self, value: list[int] = []) -> None:
        if(self.chkValue(value)):
            self.value = value;
        else:
            raise ValueError("Invalid value for Gene.");
        return;
    
    def chkValue(self, value: list[int]) -> bool:
        """Checks if the value of the `Gene` is valid. A valid value is a list of 0s and 1s.
        
        Args:
            value (list[int]): The value to check.
        
        Returns:
            bool: True if the value is valid, False otherwise.
        """
        return all(x in [0, 1] for x in value);
    
    def __int__(self, base: int = 2) -> int:
        return int("".join([str(x) for x in self.value]), base);
    
    @abstractmethod
    def mutate(self, probability: float) -> bool:
        raise NotImplementedError("Subclasses must implement mutate.");
    
    @abstractmethod
    def crossover(self, other: Gene) -> bool:
        raise NotImplementedError("Subclasses must implement crossover.");
    
    def __str__(self) -> str:
        return " ".join([str(x) for x in self.value]);
    
    def __repr__(self) -> str:
        return " ".join([str(x) for x in self.value]);
    
    def float(self, base: int = 2) -> float:
        return float(int("".join([str(x) for x in self.value]), base)) / (2**len(self.value) - 1);

class BitGene(Gene):
    """A `BitGene` is a single element of a `Chromosome`. It is implement as an array of bits.
    
    Attributes:
        value (list[int]): A list of bits that represent the value of the `BitGene`.
        
    Methods:
        __int__(self, base: int = 2)        : Returns the value of the `BitGene` as an integer.
        mutate(self, probability: float)    : Mutates the `BitGene` with a given probability. Should be overridden in subclasses.
        crossover(self, other: BitGene)     : Crossovers the `BitGene` with another `BitGene`. Should be overridden in subclasses.
    """
    def __init__(self, value: list[int] = []) -> None:
        super().__init__(value);
        
        self._min = 0;
        self._max = 1;
        
        return;
    
    def mutate(self, probability: float) -> bool:
        if random.random() < probability:
            self.value[int(random.random() * len(self.value))] = int(random.random());
            return True;
        return False;
    
    def crossover(self, other: BitGene) -> bool:
        if random.random() < 0.5:
            self.value = other.value;
            return True;
        return False;


class ColorUtils:
    @staticmethod
    def to_hex(r: int, g: int, b: int) -> str:
        return "#{:02x}{:02x}{:02x}".format(r, g, b);
    
    @staticmethod
    def to_rgb(hex: str) -> tuple[int, int, int]:
        return tuple(int(hex.lstrip('#')[i:i+2], 16) for i in (0, 2, 4));
    
    @staticmethod
    def to_hex(rgb: tuple[int, int, int]) -> str:
        return ColorUtils.to_hex(rgb[0], rgb[1], rgb[2]);
    
    @staticmethod
    def to_rgb(hex: str) -> tuple[int, int, int]:
        return ColorUtils.to_rgb(hex);
    
    @staticmethod
    def to_hex(rgb: list[int]) -> str:
        if(len(rgb) == 24):
            r = rgb[0:8]; g = rgb[8:16]; b = rgb[16:24];
            return "#{:02x}{:02x}{:02x}".format(int("".join([str(x) for x in r]), 2), int("".join([str(x) for x in g]), 2), int("".join([str(x) for x in b]), 2));
        return "#{:02x}{:02x}{:02x}".format(rgb[0], rgb[1], rgb[2]);
    
    
class GColor:
    def __init__(self) -> None:
        self.r : int = 0;
        self.g : int = 0;
        self.b : int = 0;
        return;
    
    def __str__(self) -> str:
        return ColorUtils.to_hex([self.r, self.g, self.b]);
    
    def __repr__(self) -> str:
        return ColorUtils.to_hex(self.r, self.g, self.b);
    
    @staticmethod
    def fromRGB(r: int, g: int, b: int) -> GColor:
        return GColor().fromRGB(r, g, b);
    
    @staticmethod
    def fromHex(hex: str) -> GColor:
        return GColor().fromHex(hex);
    
    def fromRGB(self, r: int, g: int, b: int) -> GColor:
        self.r = r; self.g = g; self.b = b;
        return self;
    
    def fromHex(self, hex: str) -> GColor:
        self.r, self.g, self.b = ColorUtils.to_rgb(hex);
        return self;
    
    def toRGB(self) -> tuple[int, int, int]:
        return (self.r, self.g, self.b);
    
    def toHex(self) -> str:
        return ColorUtils.to_hex(self.r, self.g, self.b);
    

class ColoredBitGene(BitGene):
    def __init__(self, value: list[int] = [0]*24) -> None:
        super().__init__(value);
        self.color : GColor = GColor();
        return;
    
    def mutate(self, probability: float) -> bool:
        if super().mutate(probability):
            self.color = GColor().fromRGB(self.value[0], self.value[1], self.value[2]);
            return True;
        return False;
    
    def crossover(self, other: ColoredBitGene) -> bool:
        if super().crossover(other):
            self.color = GColor().fromRGB(self.value[0], self.value[1], self.value[2]);
            return True;
        return False;
    
    def toFloat(self) -> float:
        return (BITS_TO_FLOAT(self.value[0:8], 2) + BITS_TO_FLOAT(self.value[8:16], 2) + BITS_TO_FLOAT(self.value[16:24], 2))/3;
        

#   Chromosome class is an wrapper for a list of Genes
class Chromosome:
    def __init__(self, genes: list[Gene] = []) -> None:
        self.genes : list[Gene] = genes;
        return;
    
    def __str__(self) -> str:
        str : str = "";
        genes_float : float = chromosomeToFloats(self);
        for i in range(len(self.genes)):
            str += f"{self.genes[i].__str__()} \t {genes_float[i]: <20} {BITS_TO_INT(self.genes[i].value):<10} {normalize(BITS_TO_INT(self.genes[i].value)):<10} {getColor(self.genes[i])}\n";
        return str;
    
    def __repr__(self) -> str:
        return str(self.genes);
    
    def sum(self) -> int:
        return sum([x.toInt() for x in self.genes]);
    
    def mean(self) -> float:
        return sum([x.toFloat() for x in self.genes])/len(self.genes);
    
    def add(self, gene: Gene) -> None:
        self.genes.append(gene);
        return;
    
    def remove(self, index: int) -> None:
        self.genes.pop(index);
        return;
    
    def mutate(self, probability: float) -> None:
        for gene in self.genes:
            gene.mutate(probability);
        return;

def createColoredBitGene(color: GColor
                         | tuple[int, int, int]
                         | list[int]
                         | str
                         ) -> ColoredBitGene | None:
    """Create a ColoredBitGene from a color.
    """
    #   Create a ColoredBitGene from a list of 3 integers from [0..255]
    if(isinstance(color, list) and len(color) == 3):
        return ColoredBitGene(INT_TO_BITS(color[0], 8) + INT_TO_BITS(color[1], 8) + INT_TO_BITS(color[2], 8));
    
    #   Create a ColoredBitGene from a hex string
    if(isinstance(color, str)):
        return ColoredBitGene(INT_TO_BITS(ColorUtils.to_rgb(color)[0], 8) + INT_TO_BITS(ColorUtils.to_rgb(color)[1], 8) + INT_TO_BITS(ColorUtils.to_rgb(color)[2], 8));
    
    #   Create a ColoredBitGene from a GColor
    if(isinstance(color, GColor)):
        return ColoredBitGene(INT_TO_BITS(color.r, 8) + INT_TO_BITS(color.g, 8) + INT_TO_BITS(color.b, 8));
    
    #   Create a ColoredBitGene from a tuple
    if(isinstance(color, tuple) and len(color) == 3):
        return ColoredBitGene(INT_TO_BITS(color[0], 8) + INT_TO_BITS(color[1], 8) + INT_TO_BITS(color[2], 8));
    


def createChromosome(values: list[ColoredBitGene]) -> Chromosome[ColoredBitGene]:
    """Create a Chromosome from a list of ColoredBitGenes.
    
    Args:
        values (list[ColoredBitGene]): A list of ColoredBitGenes.
    
    Returns:
        Chromosome[ColoredBitGene]: A Chromosome of ColoredBitGenes.
    """
    return Chromosome(values);

def createColoredChromosome(values: list[ColoredBitGene]
                            | list[list[int, int, int]],
                            ) -> Chromosome[ColoredBitGene]:
    #   Create a Chromosome from a list of lists of 3 integers from [0..255]
    if(isinstance(values, list) and len(values) > 0 and isinstance(values[0], list) and len(values[0]) == 3):
        return Chromosome([createColoredBitGene(x) for x in values]);
    
    #   Create a Chromosome from a list of ColoredBitGenes
    if(isinstance(values, list) and len(values) > 0 and isinstance(values[0], ColoredBitGene)):
        return Chromosome(values);

def r_createColoredChromosome(length : int = 0) -> Chromosome[ColoredBitGene] | None:
    return createColoredChromosome([[randint(0, 255), randint(0, 255), randint(0, 255)] for i in range(length)]);

def chromosomeToFloats(chromosome: Chromosome[ColoredBitGene]) -> list[float]:
    return [x.toFloat() for x in chromosome.genes];

def getColor(cb_gene: ColoredBitGene) -> tuple[int, int, int]:
    return BITS_TO_INT(cb_gene.value[0:8]), BITS_TO_INT(cb_gene.value[8:16]), BITS_TO_INT(cb_gene.value[16:24]);

if __name__ == "__main__":
    c = (r_createColoredChromosome(10));
    

    
    for i in range(16):
        c.mutate(0.1);
        
    print(c);
    print(chromosomeToFloats(c));