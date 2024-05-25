package org.sparklely.sparkle.core.events

class Event {
    private val listeners = mutableListOf<suspend (List<Any?>) -> Unit>()

    /**
     * 注册监听器，监听器会按照注册顺序依次执行，以下是示例（kotlin）
     *
     *     val event = Event() // 创建事件
     *     event.register { arguments ->
     *         val (a1, a2, a3) = arguments // 这里是参数列表，对应的是在 trigger 方法中传入的参数
     *         println("$a1, $a2, $a3") // 这里是执行逻辑
     *     }
     */
    fun register(callback: suspend (List<Any?>) -> Unit) {
        listeners.add(callback)
    }

    fun unregister(callback: suspend (List<Any?>) -> Unit) {
        listeners.remove(callback)
    }

    /**
     * 触发事件，参数列表会传递给注册的监听器，详见 register 方法
     */
    suspend fun trigger(vararg args: Any?) {
        listeners.forEach { it(args.toList()) }
    }
}

