# PSI-Android-simulation-of-Knight-Capital-DevOps-Problem
An Android primitive way of observing the logic behind the Power Peg Problem from 2012 which persuaded HFT companies into applying the methodology of DevOps


Sure! Here's the **README.md** file for your project, explaining the purpose of the code, the algorithms, and how it relates to the Knight Capital incident:

---

# Stock Trading Simulation App

## Overview

This Android application simulates two trading algorithms that perform stock transactions. One algorithm is a **Price Optimizing Algorithm** designed to buy stocks at the lowest price, and the other is a **Speed-Focused Algorithm**, which exaggerates buying the most expensive stock to demonstrate how different strategies can impact the market. The simulation mimics a scenario similar to the **Knight Capital incident**, where a misconfigured trading algorithm caused massive market disruption due to conflicting trading strategies.

## Purpose

The app demonstrates how **algorithmic trading strategies** can work in tandem or conflict, highlighting the potential for **market instability** if algorithms are not synchronized properly. The simulation exaggerates these behaviors to showcase the unintended consequences of poorly designed algorithms, similar to the **Knight Capital mistake**, where rapid, unsynchronized trading led to large financial losses.

## Components

### 1. **MainActivity.java**:
   - This is the primary activity of the app where the **RecyclerView** and buttons are set up.
   - **Two Algorithms** are implemented as separate threads:
     - **Price Optimizing Algorithm**: Buys the **cheapest stock** to simulate an efficient investment strategy.
     - **Speed-Focused Algorithm**: (Exaggerated for simulation) Buys the **most expensive stock** as fast as possible, simulating **high-frequency trading**.
   - Upon pressing the "Start Trading" button, both algorithms are executed in separate threads, and their results are displayed in the `TextView`.

### 2. **TradingAdapter.java**:
   - The `TradingAdapter` is used to bind the stock list to the `RecyclerView`. It displays the stock symbol and price for each stock.
   
### 3. **Stock.java**:
   - The `Stock` model class holds the data for each stock, including its symbol and price.

### 4. **activity_main.xml**:
   - This is the layout file that defines the UI for the app.
   - It contains:
     - A **RecyclerView** to display the stock list.
     - A **Button** to trigger the start of trading algorithms.
     - A **TextView** to display the result of the trading operations.

### 5. **stock_item.xml** (used in `TradingAdapter`):
   - This layout defines how each stock is displayed in the `RecyclerView`.

## Key Concepts

### Trading Algorithms:
1. **Price Optimizing Algorithm**:
   - Designed to buy stocks at the **lowest price**.
   - **Real-World Purpose**: To simulate a value investing strategy, focusing on the cheapest stocks to maximize returns over time.
   - **In the Simulation**: This algorithm is a more stable, slower process (simulated with a longer `Thread.sleep()` time) that attempts to **optimize for value**.

2. **Speed-Focused Algorithm**:
   - Designed to execute trades as quickly as possible, typically used in **high-frequency trading (HFT)** scenarios.
   - **Real-World Purpose**: To take advantage of quick, small market movements and provide **market liquidity** by making trades rapidly.
   - **In the Simulation**: This algorithm buys the **most expensive stock** in an exaggerated manner to simulate a high-speed trade. This is intentionally done to show how excessive speed without proper synchronization can cause **market distortions**.

### The Knight Capital Incident (Why This Simulation is Relevant):
- **Knight Capital** was a firm that lost **$440 million** in a matter of minutes due to a **malfunctioning trading algorithm**. The algorithm rapidly made **unsynchronized trades** that caused **erratic stock prices**. 
- The **Speed-Focused Algorithm** in the app exaggerates this issue by buying the most expensive stock at high speed, showing how **uncontrolled trading strategies** can lead to **massive market instability**.
- The **Price Optimizing Algorithm**, in contrast, tries to stabilize by focusing on low-cost stocks.

### Impact:
By running both algorithms simultaneously, the application simulates how two conflicting algorithms can lead to **unpredictable** or **unstable market behavior**, similar to what happened with Knight Capital.

---

## Running the App

### Prerequisites
- Android Studio
- Android SDK (API 21 or above)
- Java 8 or higher

### Steps to Run:
1. **Clone the Repository**:
   ```bash
   git clone https://github.com/your-username/stock-trading-simulation.git
   ```

2. **Open the Project** in Android Studio.

3. **Build the Project** by selecting **Build** > **Make Project**.

4. **Run the App** on an emulator or physical device.

5. **Click the "Start Trading" button** to start both trading algorithms.

### Expected Output:
- The app will display the stock list in a **RecyclerView**.
- When the button is pressed, the trading algorithms will run in parallel:
  - **Price Optimizing Algorithm** will attempt to buy the cheapest stock.
  - **Speed-Focused Algorithm** will attempt to buy the most expensive stock, simulating **high-frequency trading**.
- The result of each algorithm will be displayed in the `TextView` (e.g., which stock was bought by which algorithm and at what price).

## Files in the Project:

### 1. **MainActivity.java**: Main activity that contains the logic to trigger both algorithms.
### 2. **TradingAdapter.java**: Adapter for `RecyclerView` to display the list of stocks.
### 3. **Stock.java**: Model class representing each stock.
### 4. **activity_main.xml**: The layout file defining the UI for the app.
### 5. **stock_item.xml**: Layout for each item in the `RecyclerView`.

## Conclusion

This app serves as a **simulation** for algorithmic trading, exaggerating certain aspects (like speed and price optimization) to highlight how conflicting algorithms can destabilize the market. By using the **Knight Capital** incident as inspiration, it emphasizes the importance of **algorithm synchronization** and the **risks** associated with uncoordinated trading strategies in the financial markets.

---

Let me know if you need any more details or adjustments to the README!
