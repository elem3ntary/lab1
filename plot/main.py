import json
import matplotlib.pyplot as plt

# x - power
# y - time

with open("./results.json", "r") as file:
    parsed = json.load(file)

# x1 - powers
# x2 - time for one algo for sample space

x = list(range(7, 16))
y_times = {}
for i in parsed:
    print(f"Size: {i['size']}")
    for j in i["samples"][0]["results"]:
        # print(j)
        y_times.setdefault(j["algo"], []).append(j["time"])
        print(f"{j['algo']}: {j['time']}")


print(y_times.values())
for key, value in y_times.items():
    plt.plot(x, value, label=key)

plt.xlabel("2 ^ N")
# Set the y axis label of the current axis.
plt.ylabel("Time")
# Set a title of the current axes.
plt.title("Decreasing order array")
# show a legend on the plot
plt.legend()
# Display a figure.
plt.show()
print(parsed)
