package StorageDecorators;


import Filters.Filter;

public class FilteredStorage extends Storage {
    // OCP - we can use any filter without changing this class
    // ISP - filtering options depend of filter class not of any method of this class
    public FilteredStorage(Storage storage, Filter filter) {
      originProducts = storage.originProducts;
      products = filter.filter(storage.products);
    }
}
