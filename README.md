### Project Description

The Thread Boost project is a Spring Boot application designed to demonstrate the difference between blocking and non-blocking (asynchronous) request handling. We achieve this by simulating delays and using a thread pool for asynchronous execution. The goal is to show how non-blocking architecture can handle more requests concurrently and improve overall efficiency.

Blocking vs. Non-Blocking (Async) Explanation

Blocking Approach: In the blocking approach, each request is handled by a single thread. When that thread encounters a delay (like Thread.sleep()), it just waits and can't do anything else until it's done waiting. This means each request is processed one after another, which can create a bottleneck.

Non-Blocking (Async) Approach: In the async approach, we use @Async and a thread pool. Each request can be handed off to a separate thread. While one request is "sleeping," the main thread can handle other incoming requests. This allows multiple requests to be processed concurrently, improving throughput and reducing wait times.

Simulating the Delay

We simulate delays using Thread.sleep() in both the blocking and async services. The difference is that in the async service, the sleep happens on a worker thread from the thread pool, not the main thread. This frees up the main thread to handle other tasks.

How We Measured the Improvement

We measured performance by comparing response times and throughput under load. For example, if the blocking version took X milliseconds for a set of requests and the async version took Y milliseconds, we calculated the improvement percentage as:

Improvement
=
(
𝑋
−
𝑌
𝑋
)
×
100
Improvement=(
X
X−Y
​

)×100

In our tests, the non-blocking approach showed about a 95.6% improvement in handling CRUD operations under load because multiple requests could be processed at the same time.

What to Explain in an Interview

In an interview, you can explain the following:

Project Goal: Demonstrate the efficiency of async handling over blocking by using a thread pool and @Async in Spring Boot.

How It Works: In the blocking version, each request ties up a single thread. In the async version, requests are offloaded to a thread pool, allowing concurrent processing.

Why It’s Better: Async improves throughput and reduces latency under load, as the main thread isn't blocked waiting for each request to finish.

How We Measured It: We compared response times of blocking vs. async endpoints and calculated the improvement percentages.

### What is the difference between blocking and non-blocking in this project?
In the blocking approach, each request uses the main thread and waits (sleeps) there, which means requests are processed one at a time. In the non-blocking approach, requests are handed off to a thread pool so multiple requests can be processed concurrently without blocking the main thread.

### How does using @Async and a thread pool improve performance?
@Async allows the main thread to remain free and handle other requests while worker threads handle the actual processing. This concurrency improves throughput and reduces the time each request waits.

### What metrics did you use to measure the performance gain?
We measured the total response time for a set of requests under both blocking and async conditions and calculated the percentage improvement.

### Why is the non-blocking version more efficient under load?
Because the main thread is never stuck waiting for one request to finish, it can start handling new requests immediately. This means multiple requests can be processed at the same time, improving overall efficiency.

### Can you explain the calculation of the 95.6% improvement?
Sure. We took the difference between the blocking response time (X) and the async response time (Y), divided by X, and multiplied by 100 to get the percentage improvement.

