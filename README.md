# Ants Adapter
[![](https://jitpack.io/v/Papashkin/ants_base_adapter.svg)](https://jitpack.io/#Papashkin/ants_base_adapter)


## Description
Ants Adapter is a base Adapter built on [RecyclerView.Adapter](https://developer.android.com/reference/android/support/v7/widget/RecyclerView.Adapter) and [RecyclerView.ViewHolder](https://developer.android.com/reference/android/support/v7/widget/RecyclerView.ViewHolder.html). This simple adapter allows to develop and manage adapters classes easier.
You also can use [DiffUtil.Callback](https://developer.android.com/reference/android/support/v7/util/DiffUtil.Callback) or use Ants Adapter without mentioned callback.

## Implementation

Use following code for library implementation:

1. Insert into project *`build.gradle`* file:
```
maven {
    url 'https://jitpack.io'
}
```

2. Insert into the application *`build.gradle`* file:
```
dependencies {
	implementation 'com.github.Papashkin:ants_base_adapter:1.1.0'
}
```

## Adapter and ViewHolder

1. You create an adapter class extended on `AntsBaseAdapter`:

```
class TestAdapter : AntsAdapter<TestViewHolder, UserModel>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestViewHolder {
        // create viewHolder here
    }
}
```
and a class which is extends on `AntsViewHolder` :
```
class TestViewHolder(view: View) : AntsViewHolder<UserModel>(view) {
    override fun bind(item: UserModel, position: Int) {
        // do something here
    }
}
```

for creating `ViewHolder` you can use an embeded method `inflate`. This method returns a view :
```
inflate(parent, R.layout.name_of_your_layout)
```
This method returns a view.


As mentioned before `AntsViewHolder` base on generics, and in that case the method `bind` will be overriden with type you need. For example, you have data class `UserModel`:
```
data class UserModel(
    var name: String,
    var surname : String,
    var age: Int
)
```
in this case the `bind` method will looks like following code:
```
override fun bind(item: UserModel, position: Int) {
        with(item as UserModel) {
            // do something with UserModel item
        }
    }
```

## Callback

If you use the `DiffUtil` callback, you also can extend it from `AntsBaseCallback` instead `DiffUtil.Callback`.
All what you need is override the two methods from `DiffUtil.Callback` :
```
class TestCallback : AntsBaseCallback<UserModel>() {
    override fun areItemsTheSame(p0: Int, p1: Int): Boolean {
        // compare two items here
    }

    override fun areContentsTheSame(p0: Int, p1: Int): Boolean {
        // full comparing of items here 
    }

}
```
You also no need to set old and new list in callback instance constructor.
And this allows you to create an instance of Callback as singleton using DI libs and Frameworks:

```
// Kodein example:
bind<TestCallback>() with singleton { TestCallback() }

// KOIN example:
val testModule = module { 
  single { TestCallback() } 
}
```
## Example
You can find the example of *Ants Adapter* [here](sample)


## Authors
Pavel Antoshkin ([Papashkin](https://github.com/Papashkin)) - *full realization*


## License
This project is licensed under the MIT License - see the [license file](LICENSE.md) for details.
