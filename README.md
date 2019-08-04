# cell-adapter
Simple adapter for speedy implementation list of items

[![](https://jitpack.io/v/whalemare/cell-adapter.svg)](https://jitpack.io/#whalemare/cell-adapter)

Usage
-----

Use it in Kotlin with `apply` extension

```kotlin
val recycler = findViewById(R.id.recycler_view) as RecyclerView
recycler.adapter = CellAdapter(cells(AnimalBaseCell(), PersonBaseCell()), items)
recycler.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
```

Your need to write you own implementation of Cell like this
```kotlin
class PersonBaseCell : CellDelegate<Person>(R.layout.cell_person) {
    override fun isViewType(value: Any) = value is Person // define some logic for indeterminate that it is your view for render
    
    override fun bind(holder: ru.whalemare.celladapter.ViewHolder, item: Person) {
        holder.setText(R.id.text_name, item.name)
    }
}
```

Logic for checking view for render can be more complicated, than just check instance of view. 
For example:
```kotlin
    override fun isViewType(value: Any) {
        return (value as Person)?.name?.length > 0
    }
```

That is all.

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
