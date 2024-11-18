""" `Genes.py` module
The `Genes.py` module contains the `Gene` class, which is a single element of a `Chromosome`.
"""

from __future__ import annotations;

import random;

class Gene:
    """A `Gene` is a single element of a `Chromosome`. It is implemented as a byte array.
    It has the following properties:
    """
    def __init__(self, length: int = 1, _value: bytearray = None) -> None:
        self.length = length;
        self.value = bytearray(length);
        
        if _value is not None:
            self.value = _value;

    def __str__(self) -> str:
        return str(list(self.value))

    def __repr__(self) -> str:
        return str(self.value, "utf-8", errors="ignore");

    def __len__(self) -> int:
        return len(self.value);
    
    def __getitem__(self, index: int):
        return self.value[index];

    def __setitem__(self, index: int, value: int):
        self.value[index] = value;
        return;
    
    def __int__(self):
        """Integer representation of a `Gene` object."""
        return int("".join([str(int(x)) for x in self.value]));
    
class BitGene(Gene):
    """
    A `BitGene` is a single element of a `Chromosome`. It is implemented as a byte array whose values are either 0 or 1.
    """
    def __init__(self, length: int = 1, _value: bytearray = None) -> None:
        """Initializes a `BitGene` object.
        Args:
            length (int): The length of the `BitGene` object. Defaults to 1.
            _value (bytearray): The value of the `BitGene` object. Defaults to None.
        """
        super().__init__(length, _value);
        return;
    
    def mutate(self, probability: float) -> None:
        """Mutates a `BitGene` object.
        Args:
            probability (float): The probability of the mutation. Defaults to 0.01.
        """
        for i in range(len(self.value)):
            if random.random() < probability:
                self.value[i] = 1 - self.value[i];
        return;
    
    def _flip(self, index: int) -> None:
        self.value[index] = 1 if self.value[index] == 0 else 0;
        return;
    
    def __setitem__(self, index: int, value: int):
        """Overrides the `__setitem__` method of the `Gene` superclass for coercing the value to 0 or 1.
        Args:
            index (int): The index of the byte to set.
            value (int): The value to set the byte to.
        """
        self.value[index] = 1 if value >= 1 else 0;
