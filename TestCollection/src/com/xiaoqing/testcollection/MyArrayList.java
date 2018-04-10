package com.xiaoqing.testcollection;

/**
 * 自己实现ArrayList底层
 * @author xiaoqing
 *
 */
public class MyArrayList {
	
	private Object[] elementData;//容器核心数组
	
	private int size;//容器中元素的多少
	
	public MyArrayList() {
		this(10);//默认容器的大小为10
	}
	
	public MyArrayList(int initialCapacity) {
		if(initialCapacity<0)//如果构造容器时，容量大小小于0，抛出异常
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
		elementData=new Object[initialCapacity];
	}
	/**
	 * 
	 * 向容器中增加元素
	 * 
	 */
	public void add(Object obj){
		ensureCapacity();//先检查是否需要扩容
		elementData[size++]=obj;
		
	}
	/**
	 * 
	 * 在指定位置插入一个元素
	 * 
	 */
	public void add(int index,Object obj){
		rangCheck(index);//先检查下标是否合法
		ensureCapacity();//再检查容量是否足够
		System.arraycopy(elementData, index, elementData, index + 1,
                size - index);
		elementData[index] =obj;
        size++;
		
	}
	/**
	 * 
	 *返回容器中元素个数 
	 *
	 */
	public int size(){
		return size;
	}
	/**
	 * 
	 * 判断容器是否为空
	 *
	 */
	public boolean isEmpty(){
		return size==0;
	}
	/**
	 * 
	 * 返回指定位置的元素
	 * 
	 */
	public Object get(int index){
		rangCheck(index);//先判断下标是否在正常位置
		return elementData[index];
	}
	/**
	 * 
	 * 移除指定位置的元素，并返回被移除的元素
	 * 
	 */
	public Object remove(int index){
		//先判断下标是否在正常位置
		rangCheck(index);
		Object oldObj=elementData[index];
		//移动
		int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(elementData, index+1, elementData, index,
                             numMoved);
        elementData[--size] = null;
		return oldObj;
	}
	/**
	 * 
	 * 移除指定的对象
	 * 
	 */
	public boolean remove(Object obj){
		if(obj==null){
			//如果删除的对象为空
			for(int i=0;i<size;i++){
				if(get(i)==null){
					remove(i);
					return true;
				}
			}
		}else{
			//如果删除的对象不为空
			for(int i=0;i<size;i++){
				if(get(i).equals(obj)){
					remove(i);
					return true;
				}
			}
		}
		return false;
	}
	/**
	 * 
	 * 设置指定位置的元素，并返回老元素
	 * 
	 */
	public Object set(int index,Object obj){
		rangCheck(index);//先检查位置
		Object oldObj=elementData[index];
		elementData[index]=obj;
		return oldObj;//返回被删除的元素
	}
	/**
	 * 
	 * 此函数用于检查是否需要扩容
	 * 
	 */
	private void ensureCapacity(){
		if(size>=elementData.length){
			//如果加入的元素放不下，数组扩容
			Object[] newArray=new Object[size*2+1];
			//老数组内容拷贝到新数组下
			System.arraycopy(elementData, 0, newArray, 0, elementData.length);
			//老数组指向新数组
			elementData=newArray;
		}
	}
	/**
	 * 
	 * 用于检查下标是否合法，如果不在范围内，则抛出异常
	 * 
	 */
	private void rangCheck(int index){
		if(index<0||index>=size)
			try {
				throw new Exception();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
