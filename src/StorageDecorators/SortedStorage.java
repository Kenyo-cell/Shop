package StorageDecorators;

import Sorters.Sorter;

public class SortedStorage extends Storage {
    public SortedStorage(Storage storage, Sorter sorter) {
        originProducts = storage.originProducts;
        products = sorter.sort(storage.products);
    }
}
