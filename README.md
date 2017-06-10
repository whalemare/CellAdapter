# cell-adapter
Simple adapter for speedy implementation list of items

[![](https://jitpack.io/v/whalemare/cell-adapter.svg)](https://jitpack.io/#whalemare/cell-adapter)

Usage
-----

Use it in Kotlin with `apply` extension

```kotlin
    fun buildRecycler(list: List<Person>) {
        val recycler = findViewById(R.id.recycler_view) as RecyclerView
        recycler.apply {
            adapter = CellAdapter(PersonCell(), list)
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        }
    }
```

Your need to write you own implementation of Cell like this
```kotlin
/** 
* 1. Your own custom implementation ViewHolder from Cell.ViewHolder
* 2. Some data class
* 3. Layout for inflate view item
*/
class PersonCell : Cell<PersonCell.ViewHolder, Person>(R.layout.cell_person) {

    // Bind your data here
    override fun bind(holder: ViewHolder, item: Person) {
        holder.textName.text = item.name
    }

    // Use function makeView() for create view
    override fun viewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(makeView(parent, viewType))
    }

    // Create ViewHolder extended from Cell.ViewHolder
    // Find your views here
    class ViewHolder(view: View) : Cell.ViewHolder(view) {
        val textName = view.findViewById(R.id.text_name) as TextView
    }
}
```

Install
-------

Be sure, that you have `Jitpack` in your root gradle file

```
allprojects {
    repositories {
      jcenter()
      maven { url "https://jitpack.io" }
    }
}
```

Include dependency with `cell-adapter` in your app.gradle file with:

```groovy
compile 'com.github.whalemare:cell-adapter:1.0'
```


License
-------

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
