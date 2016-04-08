### BaseRecycler

一个继承自RecyclerViewAdapter的Adapter

#### Dependencies

     compile 'com.android.support:appcompat-v7:23.2.1'
     compile 'com.android.support:recyclerview-v7:23.2.1'
    
#### Introduction

使用Adapter为视图适配数据时通常会遇到两种情况:

- 同一数据, 不同数据格式(比如同是新闻, 有的有图片, 有的没有图片, 有时会需要设计两种视图来显示)。
- 不同数据混合显示(比如在列表中同时显示新闻和天气)。

为了更好的应对这些情况, 为RecyclerView的Adapter做了一些改进。

1. 通常Adapter不仅需要扩充视图, 也需要为视图设置数据, 如果有多个ViewHolder会让```onCreateViewHolder```变得又长又臭。
于是可以将```setData```部分放在ViewHolder中, 并且顺便把扩充视图的任务也转移到ViewHolder中, Adapter主要负责获取ViewHolder。
这样Adapter就从原来的"数据适配器", 变成了"ViewHolder适配器", 但Adapter仍然负责获取和更新数据源。

2. 声明一个接口用于定义数据类型, 表示该数据实体是待适配的, 将该数据类型的ViewType声明在数据类内部, Adapter中的对ViewType的判断就变得简单。
而且因为在Adapter中不再```setData()```, 只需要```getViewType()```, 甚至可以将数据源声明成```List<ItemViewModel>```。

```
    @Override
    public int getItemViewType(int position) {
        return mDataList.get(position).getViewType();
    }
```

使用时, 继承```BaseRecyclerAdapter```, 实现方法, 内部根据ViewType返回不同的ViewHolder。

```
  @NonNull
    @Override
    protected BaseViewHolder OnCreateViewHolder(ViewGroup prarent, int viewType) {
        switch (viewType){
            case Person.SOME_THING_DIFFERENT: return new TroubleViewHolder(prarent);
            case Person.VIEW_TYPE: return new PersonViewHolder(prarent);
            default: throw new IllegalArgumentException("No matched view type!");
        }
    }
```

事件监听可在ViewHolder中使用itemview.setOnclickListener()

详细参见demo, 此类可自由粘贴使用。
